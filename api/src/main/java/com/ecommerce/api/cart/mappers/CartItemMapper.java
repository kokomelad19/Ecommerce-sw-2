package com.ecommerce.api.cart.mappers;

import com.ecommerce.api.cart.dto.output.CartItemsDto;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = ProductMapper.class)
public interface CartItemMapper {
    CartItemsDto toDto(CartItem cartItem);
}
