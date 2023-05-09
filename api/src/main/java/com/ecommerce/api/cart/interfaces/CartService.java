package com.ecommerce.api.cart.interfaces;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.user.models.User;

import java.util.List;


public interface CartService {
    public CartItemDto addToCart(AddToCartDto addToCartDto , User user);

    public List<CartItemDto> getUserCart(User user);

    public void removeFromCart(long productId , User user);
}
