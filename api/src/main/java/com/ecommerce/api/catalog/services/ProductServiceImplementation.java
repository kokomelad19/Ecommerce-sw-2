package com.ecommerce.api.catalog.services;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.interfaces.ProductService;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.catalog.repository.CategoryRepository;
import com.ecommerce.api.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


    public ProductDto createProduct(CreateProductDto createProductDto) {
        Category category = categoryRepository.findById(createProductDto.getCategoryId()).orElse(null);

        Product product = productMapper.toEntity(createProductDto);

        product.setCategory(category);

        return productMapper.toDto(productRepository.save(product));
    }
}
