package com.ecommerce.api.catalog.services;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.interfaces.CategoryService;
import com.ecommerce.api.catalog.interfaces.ProductService;
import com.ecommerce.api.catalog.mappers.CategoryMapper;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.catalog.repository.ProductRepository;
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


    public List<ProductDto> getAllProducts() {
        return productMapper.toDto(productRepository.findAll());
    }
}

















