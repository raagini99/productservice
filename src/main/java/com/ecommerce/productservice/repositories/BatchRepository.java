package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> { //Long is for ID
    //*
    //Remove as mapped super class to use below methods.
    List<Batch> findAllById(Iterable<Long> ids);
    Batch save(Batch batch);
    //Batch saveAndFlush(Batch batch);
    //List<Batch> saveAll(List<Batch> batches);
    //*/
}