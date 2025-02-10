package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.Product;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductController {

    // GET http://localhost:8080/products/15 (Correct)
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Here is your product "+id;
    }

    // GET http://localhost:8080/products/15 (Wrong)
    // GET http://localhost:8080/products/15/xyz (Correct)
    @GetMapping("/{id}/{temp}")
    public String getProductById(@PathVariable("id") Long id, @PathVariable("temp") String x) {
        return "Here is your product "+id+x;
    }

    //GET http://localhost:8080/products (Wrong)
    //POST http://localhost:8080/products (Correct)
    @PostMapping("")
    public String createProduct() {
        return "Product created";
    }

    /*
    On Postman: Body -> Raw -> JSON
    {
        "name": "Wheel",
        "price": 120
    }
    */
    @PostMapping("/{id}")
    public String createProduct(@PathVariable("id") Long id, @RequestBody Product product) { //De-serializes
        product.setId(id);
        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Price: " + product.getPrice());
        return "Product created";
    }
}