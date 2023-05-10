package com.ecommerce.api.order.mappers;


import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.models.Order;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring" , uses = OrderItemMapper.class)
public interface OrderMapper {

    OrderDto toDto(Order order);

    List<OrderDto> toDto(List<Order> orders);
}
