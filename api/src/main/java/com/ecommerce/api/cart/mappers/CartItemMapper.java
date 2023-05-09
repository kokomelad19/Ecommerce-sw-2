package com.ecommerce.api.cart.mappers;

import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = ProductMapper.class)
public interface CartItemMapper {
    CartItemDto toDto(CartItem cartItem);

    List<CartItemDto> toDto(List<CartItem> cartItems);
}
