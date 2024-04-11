package com.menora.eventsreader.repositories;

import com.menora.eventsreader.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String>  {
}
