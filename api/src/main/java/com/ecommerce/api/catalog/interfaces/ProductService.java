package com.ecommerce.api.catalog.interfaces;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.input.UpdateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(CreateProductDto createProductDto);

    public ProductDto updateProduct(long productId , UpdateProductDto updateProductDto);

    public void deleteProductById(long productId);

    public List<ProductDto> getAllProducts();

    public ProductDto getProductById(long productId);
}
