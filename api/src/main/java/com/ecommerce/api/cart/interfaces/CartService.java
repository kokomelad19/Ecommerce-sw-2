package com.ecommerce.api.cart.interfaces;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemsDto;
import com.ecommerce.api.users.models.Users;


public interface CartService {
    public CartItemsDto addToCart(AddToCartDto addToCartDto , Users user);
}
