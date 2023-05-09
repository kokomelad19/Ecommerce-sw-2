package com.ecommerce.api.cart.mappers;

import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T21:47:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public CartItemDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemsDto = new CartItemDto();

        cartItemsDto.setId( cartItem.getId() );
        cartItemsDto.setProduct( productMapper.toDto( cartItem.getProduct() ) );
        cartItemsDto.setQuantity( cartItem.getQuantity() );

        return cartItemsDto;
    }

    @Override
    public List<CartItemDto> toDto(List<CartItem> cartItems) {
        if ( cartItems == null ) {
            return null;
        }

        List<CartItemDto> list = new ArrayList<CartItemDto>( cartItems.size() );
        for ( CartItem cartItem : cartItems ) {
            list.add( toDto( cartItem ) );
        }

        return list;
    }
}
