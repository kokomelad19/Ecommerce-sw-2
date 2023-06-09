package com.ecommerce.api.order.controllers;

import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.input.UpdateOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.interfaces.OrderService;
import com.ecommerce.api.user.models.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody @Valid PlaceOrderDto placeOrderDto, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(orderService.placeOrder(placeOrderDto, user), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/my-list")
    public ResponseEntity<List<OrderDto>> getUserOrders(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderService.getUserOrders(user));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable @Positive long orderId, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderService.getOrderById(orderId, user));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable @Positive long orderId, @RequestBody @Valid UpdateOrderDto updateOrderDto) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, updateOrderDto));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable @Positive long orderId,@AuthenticationPrincipal User user) {
        orderService.cancelOrder(orderId , user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
