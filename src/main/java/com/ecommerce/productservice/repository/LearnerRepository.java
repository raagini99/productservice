package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import java.util.List;

public interface LearnerRepository extends JpaRepository<Learner, UUID> {

    Learner getLearnerByEmail(String email);
}
