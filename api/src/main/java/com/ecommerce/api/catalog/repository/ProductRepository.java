package com.ecommerce.api.catalog.repository;

import com.ecommerce.api.catalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
