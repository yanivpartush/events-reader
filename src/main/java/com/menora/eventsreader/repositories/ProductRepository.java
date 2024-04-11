package com.menora.eventsreader.repositories;

import com.menora.eventsreader.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("SELECT p FROM Product p " +
            "INNER JOIN Insured i ON p.insured.id = i.id " +
            "INNER JOIN Company c ON c.id = i.company.id " +
            "WHERE i.id = :insuredId AND c.id = :companyId")
    List<Product> getProductsByInsuredIdAndCompanyId(@Param("insuredId") String insuredId,@Param("companyId") String companyId);

}
