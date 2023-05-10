package com.ecommerce.api.cart.mappers;

import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.models.CartItem;
import com.ecommerce.api.cart.models.CartItem.CartItemBuilder;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T01:46:43+0200",
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

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setId( cartItem.getId() );
        cartItemDto.setProduct( productMapper.toDto( cartItem.getProduct() ) );
        cartItemDto.setQuantity( cartItem.getQuantity() );

        return cartItemDto;
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

    @Override
    public List<CartItem> toEntity(List<CartItemDto> cartItems) {
        if ( cartItems == null ) {
            return null;
        }

        List<CartItem> list = new ArrayList<CartItem>( cartItems.size() );
        for ( CartItemDto cartItemDto : cartItems ) {
            list.add( cartItemDtoToCartItem( cartItemDto ) );
        }

        return list;
    }

    protected CartItem cartItemDtoToCartItem(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItemBuilder cartItem = CartItem.builder();

        cartItem.id( cartItemDto.getId() );
        cartItem.product( productMapper.toEntity( cartItemDto.getProduct() ) );
        cartItem.quantity( cartItemDto.getQuantity() );

        return cartItem.build();
    }
}
