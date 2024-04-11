package com.menora.eventsreader.services.db;

import com.menora.eventsreader.controllers.dto.response.CompanyResponseDto;
import com.menora.eventsreader.controllers.dto.response.InsuredResponseDto;
import com.menora.eventsreader.controllers.dto.response.ProductResponseDto;
import com.menora.eventsreader.entities.Company;
import com.menora.eventsreader.entities.Product;
import com.menora.eventsreader.repositories.CompanyRepository;
import com.menora.eventsreader.repositories.InsuredRepository;
import com.menora.eventsreader.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyResponseDto> getInsuredById(String insuredId) {

        List<Company> companies = companyRepository.findAll();
        List<CompanyResponseDto> companyResponseDtoList = new ArrayList<>();
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        for (Company company : companies) {
            List<Product> products = productRepository.getProductsByInsuredIdAndCompanyId(insuredId, company.getId());
            if (products != null && !products.isEmpty()) {
                List<ProductResponseDto> productsResDto = productsResponseDto(products);
                companyResponseDto = CompanyResponseDto.builder().id(company.getId())
                                                       .sourceCompany(company.getSourceCompany())
                                                       .build();
                InsuredResponseDto insuredResponseDto = InsuredResponseDto.builder().id(insuredId).build();
                insuredResponseDto.setProducts(productsResDto);
                companyResponseDto.setInsureds(List.of(insuredResponseDto));
            }

            companyResponseDtoList.add(companyResponseDto);
        }
        return companyResponseDtoList;
    }

    private List<ProductResponseDto> productsResponseDto(List<Product> products) {
        List<ProductResponseDto> ans = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = ProductResponseDto.builder().price(product.getPrice())
                                                                      .id(product.getId())
                                                                      .type(product.getType())
                                                                      .startDate(product.getStartDate())
                                                                      .endDate(product.getEndDate()).build();
            ans.add(productResponseDto);
        }
        return ans;
    }
}
