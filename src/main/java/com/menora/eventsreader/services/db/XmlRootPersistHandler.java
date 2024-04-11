package com.menora.eventsreader.services.db;

import com.menora.eventsreader.entities.db.Company;
import com.menora.eventsreader.entities.db.Insured;
import com.menora.eventsreader.entities.db.Product;
import com.menora.eventsreader.entities.xml.Event;
import com.menora.eventsreader.entities.xml.RequestDetails;
import com.menora.eventsreader.entities.xml.Root;
import com.menora.eventsreader.repositories.CompanyRepository;
import com.menora.eventsreader.repositories.InsuredRepository;
import com.menora.eventsreader.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlRootPersistHandler {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InsuredRepository insuredRepository;


    public String persist(Root rootObject) {
        if (rootObject != null) {
            Company company = saveCompany(rootObject);
            for (Event event : rootObject.getEvents()) {
                Insured insured = saveInsured(event, company);
                saveProducts(event, insured);
            }
            return company.getId();
        }
        return null;
    }


    private Company saveCompany(Root rootObject) {
        RequestDetails requestDetails = rootObject.getRequestDetails();
        Company companyToAdd = companyRepository.findById(requestDetails.getId()).
                                                orElseGet(() -> {
                                                    Company companyToSave = Company.builder().id(requestDetails.getId())
                                                            .acceptDate(Timestamp.valueOf(requestDetails.getAcceptDate()))
                                                                                   .sourceCompany(requestDetails.getSourceCompany())
                                                                                   .build();
                                                    return companyRepository.save(companyToSave);
                                                });
        return companyToAdd;
    }

    private Insured saveInsured(Event event, Company company) {
        Insured insuredToAdd = insuredRepository.findById(event.getInsuredId()).
                                                orElseGet(() -> {
                                                    Insured insuredToSave = Insured.builder()
                                                                                   .id(event.getInsuredId())
                                                                                   .company(company)
                                                                                   .build();
                                                    return insuredRepository.save(insuredToSave);
                                                });
        return insuredToAdd;
    }


    private List<Product> saveProducts(Event event, Insured insured) {
        List<Product> products = new ArrayList<>();
        for (com.menora.eventsreader.entities.xml.Product product : event.getProducts()) {
            Product productToSave = Product.builder()
                                           .type(product.getType())
                                           .endDate(Date.valueOf(product.getEndDate()))
                                           .startDate(Date.valueOf(product.getStartDate()))
                                           .price(product.getPrice())
                                           .insured(insured)
                                           .build();

            products.add(productToSave);
        }
        return productRepository.saveAll(products);
    }

}
