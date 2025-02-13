package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //Telling {Spring Data API} or {Hibernate and Spring Data} to create a table User.
//@Entity(name = "ecommerce_user") //Renames table name in DB.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}