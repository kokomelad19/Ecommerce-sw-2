package com.ecommerce.api.order.interfaces;

import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.input.UpdateOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.user.models.User;

import java.util.List;

public interface OrderService {
    public OrderDto placeOrder(PlaceOrderDto placeOrderDto , User user);

    public List<OrderDto> getAllOrders();

    public List<OrderDto> getUserOrders(User user);

    public OrderDto getOrderById(long orderId , User user);

    public OrderDto updateOrder(long orderId , UpdateOrderDto updateOrderDto);

    public void cancelOrder(long orderId , User user);
}
