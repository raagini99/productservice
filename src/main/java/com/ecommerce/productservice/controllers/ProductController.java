package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    // GET http://localhost:8080/products/15 (Correct)
    /*
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Here is your product "+id;
    }
    */

    @GetMapping("/{id}")
    public @ResponseBody Product createProduct(@PathVariable("id") Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Dummy Product Name");
        product.setPrice(100.0);
        return product;
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