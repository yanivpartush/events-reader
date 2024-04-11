package com.menora.eventsreader.repositories;

import com.menora.eventsreader.entities.db.Insured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<Insured,String> {



}
