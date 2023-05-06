package com.ecommerce.api.catalog.interfaces;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;

public interface CategoryService {
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto);
}
