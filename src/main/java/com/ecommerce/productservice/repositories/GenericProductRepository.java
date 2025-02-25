package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.GenericProduct;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@Repository
public interface GenericProductRepository extends JpaRepository<GenericProduct, Long> {
   //void saveAll(List<GenericProduct> genericProducts);
   Page<GenericProduct> findAllBy(Pageable pageable);
   Page<GenericProduct> findAllByName(String name, Pageable pageable);
}