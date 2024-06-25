package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Override
    Optional<User> findById(UUID id);

    Optional <List<User>> findByName(String name);

    List<User> findAllByNameEndingWith(String suffix);

    User save(User entity);
}
