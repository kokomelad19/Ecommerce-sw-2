package com.ecommerce.api.order.mappers;

import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.models.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T01:46:42+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setAddress( order.getAddress() );
        orderDto.setTotalPrice( order.getTotalPrice() );
        orderDto.setOrderStatus( order.getOrderStatus() );
        orderDto.setOrderItems( orderItemMapper.toDto( order.getOrderItems() ) );

        return orderDto;
    }

    @Override
    public List<OrderDto> toDto(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( toDto( order ) );
        }

        return list;
    }
}
