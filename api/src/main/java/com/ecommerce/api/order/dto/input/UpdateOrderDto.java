package com.ecommerce.api.order.dto.input;


import com.ecommerce.api.order.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDto {
    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
