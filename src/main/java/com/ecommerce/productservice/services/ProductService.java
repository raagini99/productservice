package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public GetProductDto getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);

        GetProductDto obj = new GetProductDto();
        obj.setTitle(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImage(product.getImage());
        /*
        obj.setName("iPhone");
        obj.setPrice(75000.0);
        obj.setImageUrl("www.apple.com");
         */
        return obj;
    }

    /*
    public GetProductDto getProductById(Long id) {
        //Call the fake store API.
        //OR Call the DB layer.
        GetProductDto obj = new GetProductDto();
        obj.setName("iPhone");
        obj.setPrice(75000.0);
        obj.setImageUrl("www.apple.com");
        return obj;
    }
    */
}