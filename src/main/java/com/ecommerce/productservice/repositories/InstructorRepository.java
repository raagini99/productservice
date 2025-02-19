package com.ecommerce.productservice.repositories;


import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {
    public Instructor save(Instructor instructor);
    public List<User> findByName(String name);

    //@EntityGraph(attributePaths = "batches", type = EntityGraph.EntityGraphType.FETCH) // Fetch batches in the same query
    //Use above to always include batches in instructor queries.
    Instructor findByEmail(String email);
}