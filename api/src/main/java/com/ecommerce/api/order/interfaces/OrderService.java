package com.ecommerce.api.order.interfaces;

import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.user.models.User;

import java.util.List;

public interface OrderService {
    public OrderDto placeOrder(PlaceOrderDto placeOrderDto , User user);
}
