package com.ecommerce.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    /*
    //Does not need getters and setters.
    public Long id;
    public String name;
    public String description;
    public Double price;
    public String imageUrl;
    public String category;
    */

    //Needs getters and setters.
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
}