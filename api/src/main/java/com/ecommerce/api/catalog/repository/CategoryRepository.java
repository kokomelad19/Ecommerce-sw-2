package com.ecommerce.api.catalog.repository;

import com.ecommerce.api.catalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
