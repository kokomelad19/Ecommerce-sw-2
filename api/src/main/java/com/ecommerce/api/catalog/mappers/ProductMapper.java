package com.ecommerce.api.catalog.mappers;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.input.UpdateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" , uses = CategoryMapper.class)
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toDto(List<Product> products);



    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "category" , ignore = true)
    Product toEntity(CreateProductDto createProductDto);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "category" , ignore = true)
    Product toEntity(UpdateProductDto updateProductDto);

    Product toEntity(ProductDto productDto);
}
