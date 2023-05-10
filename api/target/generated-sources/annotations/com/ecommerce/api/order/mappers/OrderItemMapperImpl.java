package com.ecommerce.api.order.mappers;

import com.ecommerce.api.catalog.dto.output.CategoryDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.order.dto.output.OrderItemDto;
import com.ecommerce.api.order.models.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T01:46:43+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public List<OrderItemDto> toDto(List<OrderItem> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( orderItems.size() );
        for ( OrderItem orderItem : orderItems ) {
            list.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );

        return categoryDto;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setCategory( categoryToCategoryDto( product.getCategory() ) );

        return productDto;
    }

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId( orderItem.getId() );
        orderItemDto.setProduct( productToProductDto( orderItem.getProduct() ) );
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setUnitPrice( orderItem.getUnitPrice() );

        return orderItemDto;
    }
}
