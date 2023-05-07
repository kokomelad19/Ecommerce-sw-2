package com.ecommerce.api.catalog.services;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.input.UpdateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;
import com.ecommerce.api.catalog.interfaces.CategoryService;
import com.ecommerce.api.catalog.mappers.CategoryMapper;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.repository.CategoryRepository;
import com.ecommerce.api.errorHandling.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        return categoryMapper.toCategoryDto(categoryRepository.save(categoryMapper.toCategoryEntity(createCategoryDto)));
    }


    public CategoryDto updateCategory(Long categoryId, UpdateCategoryDto updateCategoryDto) {
        // Check Category Existence
        getCategoryById(categoryId);

        Category category = categoryMapper.toCategoryEntity(updateCategoryDto);
        category.setId(categoryId);

        return categoryMapper.toCategoryDto(categoryRepository.save(category));
    }

    public CategoryDto getCategoryById(Long categoryId) {
        return categoryMapper.toCategoryDto(categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category is not exist")));
    }

    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryMapper.toCategoryDto(categoryRepository.findAll());
    }
}
