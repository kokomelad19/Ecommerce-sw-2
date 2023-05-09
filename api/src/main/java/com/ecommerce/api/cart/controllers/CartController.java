package com.ecommerce.api.cart.controllers;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.interfaces.CartService;
import com.ecommerce.api.user.models.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @PostMapping("/item")
    public ResponseEntity<CartItemDto> addToCart(@RequestBody @Valid AddToCartDto addToCartDto, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(cartService.addToCart(addToCartDto, user), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CartItemDto>> getUserCart(@AuthenticationPrincipal User user) {
        return  ResponseEntity.ok(cartService.getUserCart(user));
    }

    @DeleteMapping("/item/{productId}")
    public ResponseEntity<Object> removeFromCart(@PathVariable @Positive long productId, @AuthenticationPrincipal User user) {
        cartService.removeFromCart(productId, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
