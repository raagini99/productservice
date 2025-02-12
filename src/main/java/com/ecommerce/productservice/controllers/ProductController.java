package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    /*
    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductDto(@PathVariable("id") Long id) {
        return new GetProductDto();
    }
    */

    // GET http://localhost:8080/products/15 (Correct)
    /*
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        //Dummy method.
        return "Here is your product "+id;
    }
    */

    /*
    @GetMapping("/{id}")
    public @ResponseBody Product getProductById(@PathVariable("id") Long id) {
        //Dummy method.
        Product product = new Product();
        product.setId(id);
        product.setName("Dummy Product Name");
        product.setPrice(100.0);
        return product;
    }
    */



    // GET http://localhost:8080/products/15 (Wrong)
    // GET http://localhost:8080/products/15/xyz (Correct)
    @GetMapping("/{id}/{temp}")
    public String getProductByIdAndTemp(@PathVariable("id") Long id, @PathVariable("temp") String x) {
        //Dummy method.
        return "Here is your product "+id+x;
    }

    //GET http://localhost:8080/products (Wrong)
    //POST http://localhost:8080/products (Correct)
    @PostMapping("")
    public String createProduct() {
        //Add code here. Dummy method.
        return "Product created";
    }

    /*
    On Postman: Body -> Raw -> JSON
    {
        "name": "Wheel",
        "price": 120
    }
    */

    /*
    @PostMapping("/{id}")
    public String createProductById(@PathVariable("id") Long id, @RequestBody Product product) { //De-serializes
        //Dummy method.
        product.setId(id);
        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Price: " + product.getPrice());
        return "Product created";
    }
    */
}