package com.ecommerce.api.cart.services;

import com.ecommerce.api.cart.dto.input.AddToCartDto;
import com.ecommerce.api.cart.dto.output.CartItemsDto;
import com.ecommerce.api.cart.interfaces.CartService;
import com.ecommerce.api.cart.mappers.CartItemMapper;
import com.ecommerce.api.cart.models.Cart;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.cart.models.CartItemId;
import com.ecommerce.api.cart.repository.CartItemRepository;
import com.ecommerce.api.cart.repository.CartRepository;
import com.ecommerce.api.catalog.interfaces.ProductService;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.users.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final CartItemMapper cartItemMapper;

    private final ProductService productService;

    private final ProductMapper productMapper;

    @Transactional
    public CartItemsDto addToCart(AddToCartDto addToCartDto, Users user) {
        // check if user has no cart then create one
        Cart cart = cartRepository.findByUser(user).orElseGet(() -> {
            Cart userCart = Cart.builder().user(user).build();
            return cartRepository.save(userCart);
        });

        // Get Product By ID
        Product product = productMapper.toEntity(productService.getProductById(addToCartDto.getProductId()));

        // Set Composite Key
        CartItemId cartItemId = CartItemId.builder()
                .cartId(cart.getId())
                .productId(product.getId())
                .build();

        CartItem cartItem = CartItem.builder()
                .id(cartItemId)
                .cart(cart)
                .product(product)
                .quantity(addToCartDto.getQuantity())
                .build();

        return cartItemMapper.toDto(cartItemRepository.save(cartItem));
    }
}
