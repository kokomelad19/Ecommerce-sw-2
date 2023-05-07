package com.ecommerce.api.catalog.interfaces;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.input.UpdateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;

import java.util.List;

public interface CategoryService {
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto);

    public CategoryDto updateCategory(Long categoryId , UpdateCategoryDto updateCategoryDto);

    public CategoryDto getCategoryById(Long categoryId);

    public void deleteCategoryById(Long categoryId);

    public List<CategoryDto> getAllCategories();
}
