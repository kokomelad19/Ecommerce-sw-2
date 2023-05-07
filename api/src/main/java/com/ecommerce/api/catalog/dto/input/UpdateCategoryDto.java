package com.ecommerce.api.catalog.dto.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryDto {
    @NotEmpty(message = "Category name is required")
    private String name;

    @NotEmpty(message = "Category description is required")
    private String description;
}
