package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { //Long is for ID
    //*
    //Remove as mapped super class to use below methods.
    @Override
    Optional<User> findById(UUID id);
    Optional<List<User>> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findAllByNameEndsWith(String suffix);
    //@Query("SELECT name FROM User")
    //Optional<User> findByName(String name);
    User save(User user);
    //*/
}