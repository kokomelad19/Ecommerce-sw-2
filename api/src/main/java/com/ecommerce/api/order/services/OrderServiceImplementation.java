package com.ecommerce.api.order.services;

import com.ecommerce.api.cart.dto.output.CartItemDto;
import com.ecommerce.api.cart.interfaces.CartService;
import com.ecommerce.api.catalog.mappers.ProductMapper;
import com.ecommerce.api.errorHandling.RecordNotFoundException;
import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.input.UpdateOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.enums.OrderStatus;
import com.ecommerce.api.order.interfaces.OrderService;
import com.ecommerce.api.order.mappers.OrderMapper;
import com.ecommerce.api.order.models.Order;
import com.ecommerce.api.order.models.OrderItem;
import com.ecommerce.api.order.models.OrderItemId;
import com.ecommerce.api.order.repository.OrderItemRepository;
import com.ecommerce.api.order.repository.OrderRepository;
import com.ecommerce.api.user.enums.UserType;
import com.ecommerce.api.user.models.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        Order order = Order.builder().address(placeOrderDto.getAddress()).user(user).build();

        // Get User Cart Items
        List<CartItemDto> cartItems = cartService.getUserCart(user);

        if (cartItems.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "order must have at least 1 item, please add one to your cart");
        }

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

    public List<OrderDto> getAllOrders() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    public List<OrderDto> getUserOrders(User user) {
        return orderMapper.toDto(orderRepository.findByUser(user));
    }

    public OrderDto getOrderById(long orderId, User user) {
        Order order = null;

        if (user.getUserType() == UserType.ADMIN) {
            order = checkOrderExistence(orderId, null);
        } else {
            order = checkOrderExistence(orderId, user);
        }

        return orderMapper.toDto(order);
    }

    public OrderDto updateOrder(long orderId, UpdateOrderDto updateOrderDto) {
        Order order = checkOrderExistence(orderId, null);

        order.setAddress(updateOrderDto.getAddress());
        order.setOrderStatus(updateOrderDto.getOrderStatus());

        return orderMapper.toDto(orderRepository.save(order));
    }

    public void cancelOrder(long orderId, User user) {
        Order order = checkOrderExistence(orderId, user);
        order.setOrderStatus(OrderStatus.CANCELLED);

        orderRepository.save(order);
    }


    private BigDecimal calculateTotalPrice(@NotNull List<CartItemDto> cartItems) {
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

    private Order checkOrderExistence(long orderId, User user) {
        if (user != null) {
            return orderRepository.findByIdAndUser(orderId, user).orElseThrow(() -> new RecordNotFoundException("order is not exist"));
        }

        return orderRepository.findById(orderId).orElseThrow(() -> new RecordNotFoundException("order is not exist"));
    }
}
