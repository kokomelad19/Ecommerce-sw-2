package com.ecommerce.api.cart.repository;

import com.ecommerce.api.cart.models.Cart;
import com.ecommerce.api.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long> {
    Optional<Cart> findByUser(User user);
}
