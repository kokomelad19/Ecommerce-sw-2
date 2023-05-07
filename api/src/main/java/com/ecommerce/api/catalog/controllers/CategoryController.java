package com.ecommerce.api.catalog.controllers;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.input.UpdateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;
import com.ecommerce.api.catalog.interfaces.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(createCategoryDto), HttpStatus.CREATED);
    }


    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId, @RequestBody @Valid UpdateCategoryDto updateCategoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, updateCategoryDto));
    }


    @DeleteMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }
}
