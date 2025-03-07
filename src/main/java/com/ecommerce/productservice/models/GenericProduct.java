package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GenericProduct{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;

    public GenericProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }
}