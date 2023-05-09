package com.ecommerce.api.cart.interfaces;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.users.models.Users;

import java.util.List;


public interface CartService {
    public CartItemDto addToCart(AddToCartDto addToCartDto , Users user);

    public List<CartItemDto> getUserCart(Users user);

    public void removeFromCart(long productId , Users user);
}
