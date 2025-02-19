package com.ecommerce.productservice.repositories;


import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {
    public Instructor save(Instructor instructor);
    public List<User> findByName(String name);

    Instructor findByEmail(String email);
}