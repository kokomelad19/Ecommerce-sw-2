package com.ecommerce.api.order.dto.output;

import com.ecommerce.api.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private String address;

    private BigDecimal totalPrice;

    private OrderStatus orderStatus;

    private List<OrderItemDto> orderItems;
}
