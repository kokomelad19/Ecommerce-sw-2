package com.ecommerce.api.catalog.services;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.input.UpdateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.interfaces.CategoryService;
import com.ecommerce.api.catalog.interfaces.ProductService;
import com.ecommerce.api.catalog.mappers.CategoryMapper;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.catalog.repository.ProductRepository;
import com.ecommerce.api.errorHandling.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;


    public ProductDto createProduct(CreateProductDto createProductDto) {
        Category category = categoryMapper.toCategoryEntity(categoryService.getCategoryById(createProductDto.getCategoryId()));

        Product product = productMapper.toEntity(createProductDto);

        product.setCategory(category);

        return productMapper.toDto(productRepository.save(product));
    }


    public ProductDto updateProduct(long productId, UpdateProductDto updateProductDto) {
        // Check Product Existence
        getProductById(productId);

        // Get Category
        Category category = categoryMapper.toCategoryEntity(categoryService.getCategoryById(updateProductDto.getCategoryId()));

        // map DTO to Entity
        Product product = productMapper.toEntity(updateProductDto);

        // Set missing data
        product.setId(productId);
        product.setCategory(category);

        // return mapped updated product to DTO
        return productMapper.toDto(productRepository.save(product));
    }


    public void deleteProductById(long productId) {
        productRepository.deleteById(productId);
    }


    public List<ProductDto> getAllProducts() {
        return productMapper.toDto(productRepository.findAll());
    }

    public ProductDto getProductById(long productId) {
        return productMapper.toDto(productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product is not exist")));
    }
}

















