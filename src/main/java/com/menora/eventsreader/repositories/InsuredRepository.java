package com.menora.eventsreader.repositories;

import com.menora.eventsreader.entities.Insured;
import com.menora.eventsreader.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuredRepository extends JpaRepository<Insured,String> {




}
