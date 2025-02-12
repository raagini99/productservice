package com.ecommerce.productservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data //Doesn't show address when called. Instead, shows attributes and values.
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
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private String seller;
}