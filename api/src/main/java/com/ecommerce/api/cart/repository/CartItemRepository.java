package com.ecommerce.api.cart.repository;

import com.ecommerce.api.cart.models.Cart;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.cart.models.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem , CartItemId> {
    public List<CartItem> findByCart(Cart cart);

    public void deleteByCart(Cart cart);
}
