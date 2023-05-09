package com.ecommerce.api.cart.controllers;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemsDto;
import com.ecommerce.api.cart.interfaces.CartService;
import com.ecommerce.api.users.models.Users;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @PostMapping("/item")
    public ResponseEntity<CartItemsDto> addToCart(@RequestBody @Valid AddToCartDto addToCartDto , @AuthenticationPrincipal Users user) {
        return new ResponseEntity<>(cartService.addToCart(addToCartDto , user) , HttpStatus.CREATED);
    }

}
