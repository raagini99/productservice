package com.ecommerce.productservice.models;


import jakarta.persistence.*;

@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer strength;
    @ManyToOne
    private Instructor instructor;
}