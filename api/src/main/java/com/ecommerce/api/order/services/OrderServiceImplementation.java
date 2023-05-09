package com.ecommerce.api.order.services;

import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.interfaces.CartService;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.interfaces.OrderService;
import com.ecommerce.api.order.mappers.OrderMapper;
import com.ecommerce.api.order.models.Order;
import com.ecommerce.api.order.models.OrderItem;
import com.ecommerce.api.order.models.OrderItemId;
import com.ecommerce.api.order.repository.OrderItemRepository;
import com.ecommerce.api.order.repository.OrderRepository;
import com.ecommerce.api.user.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final CartService cartService;

    private final ProductMapper productMapper;

    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto placeOrder(PlaceOrderDto placeOrderDto, User user) {
        // Initialize Order
        Order order = Order.builder()
                .address(placeOrderDto.getAddress())
                .user(user)
                .build();

        // Get User Cart Items
        List<CartItemDto> cartItems = cartService.getUserCart(user);

        // Calculate Total Price
        order.setTotalPrice(calculateTotalPrice(cartItems));

        // Save Order
        Order createdOrder = orderRepository.save(order);

        // Save Order items
        createdOrder.setOrderItems(orderItemRepository.saveAll(getOrderItemsFromCart(cartItems, createdOrder)));

        // Delete all items from cart
        cartService.deleteAllItems(cartItems);

        return orderMapper.toDto(createdOrder);
    }


    private BigDecimal calculateTotalPrice(List<CartItemDto> cartItems) {
        return cartItems.stream().map(cartItem -> cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<OrderItem> getOrderItemsFromCart(List<CartItemDto> cartItems, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItemDto cartItem : cartItems) {
            OrderItemId orderItemId = OrderItemId.builder().orderId(order.getId()).productId(cartItem.getProduct().getId()).build();
            orderItems.add(OrderItem.builder().id(orderItemId).unitPrice(cartItem.getProduct().getPrice()).order(order).product(productMapper.toEntity(cartItem.getProduct())).quantity(cartItem.getQuantity()).build());
        }

        return orderItems;
    }
}
