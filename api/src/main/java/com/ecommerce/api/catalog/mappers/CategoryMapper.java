package com.ecommerce.api.catalog.mappers;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.input.UpdateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;
import com.ecommerce.api.catalog.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDto(List<Category> category);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "products" , ignore = true)
    Category toCategoryEntity(CreateCategoryDto categoryDto);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "products" , ignore = true)
    Category toCategoryEntity(UpdateCategoryDto categoryDto);
}
