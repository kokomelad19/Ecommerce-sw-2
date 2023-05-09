package com.ecommerce.api.catalog.controllers;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid CreateProductDto createProductDto) {
        return new ResponseEntity<>(productService.createProduct(createProductDto) , HttpStatus.CREATED);
    }



    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
