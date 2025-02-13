package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public GetProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);
        //Product product = restTemplate.getForObject(url, String.class);
        System.out.println(product);

        if (product == null) {
            throw new NotFoundException();
        }

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

    public List<GetProductDto> getAllProducts() {
        //Call third party API. Deserialize into Java object (Array of products).
        //Convert the array into a list of dto objects.
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        //Here, list doesn't work. Array works.
        System.out.println(products);

        List<GetProductDto> returnProducts = new ArrayList<>();
        //Array doesn't seem to appear in JSON list.
        //Therefore, use list.

        for (Product product : products) {
            returnProducts.add(convertToProductDto(product));
        }
        return returnProducts;
        /*
        GetProductDto[] array = new GetProductDto[products.length];
        int idx = 0;
        for (Product product : products) {
            array[idx] = convertToProductDto(product);
        }
        return array;
        */
    }

    private GetProductDto convertToProductDto(Product product) {
        GetProductDto obj = new GetProductDto();
        obj.setTitle(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImage(product.getImage());
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

/*
DEFAULT LOCATION FOR OPENAPI DOCS
http://localhost:8080/v3/api-docs

CHANGE LOCATION IN application.properties
http://localhost:8080/api-docs

ACCESS SWAGGER UI AT
http://localhost:8080/swagger-ui/index.html
*/