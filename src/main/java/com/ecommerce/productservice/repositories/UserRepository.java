package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //Long is for ID
    //@Override
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findAllByNameEndsWith(String suffix);
    User save(User user);
}