package com.ecommerce.api.catalog.interfaces;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(CreateProductDto createProductDto);

    public List<ProductDto> getAllProducts();
}
