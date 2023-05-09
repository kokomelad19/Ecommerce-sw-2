package com.ecommerce.api.order.mappers;

import com.ecommerce.api.order.dto.output.OrderItemDto;
import com.ecommerce.api.order.models.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    List<OrderItemDto> toDto(List<OrderItem> orderItems);
}
