package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.GenericProduct;
import com.ecommerce.productservice.services.GenericProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.productservice.services.GenericProductService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final GenericProductService genericProductService;

    public SearchController(GenericProductService genericProductService) {
        this.genericProductService = genericProductService;
    }

    @GetMapping("/generate")
    public ResponseEntity search(){
        return ResponseEntity.ok(genericProductService.generateProductData());
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenericProduct>> searchProducts(@RequestParam(value = "q", required = false) String query){
        return ResponseEntity.ok(genericProductService.searchProducts(query));
    }

    @GetMapping("")
    public ResponseEntity<Page<GenericProduct>> searchProductsByPage(
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "pageNo") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
            @RequestParam(value = "sorting", required = false, defaultValue = "id-asc") String sorting) {
        return ResponseEntity.ok(
                genericProductService.searchProductsByPagination
                        (query, pageNumber, pageSize, sorting));
    }
}