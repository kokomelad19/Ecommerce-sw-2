package com.ecommerce.api.order.controllers;

import com.ecommerce.api.order.dto.input.PlaceOrderDto;
import com.ecommerce.api.order.dto.output.OrderDto;
import com.ecommerce.api.order.interfaces.OrderService;
import com.ecommerce.api.user.models.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody @Valid PlaceOrderDto placeOrderDto, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(orderService.placeOrder(placeOrderDto , user) , HttpStatus.CREATED);
    }
}
