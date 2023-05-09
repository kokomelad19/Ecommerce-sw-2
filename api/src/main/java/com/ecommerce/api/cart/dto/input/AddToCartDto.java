package com.ecommerce.api.cart.dto.input;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDto {
    @NotNull(message = "Product is required")
    @Positive(message = "Invalid product")
    private Long productId;

    @NotNull(message = "Product quantity is required")
    @DecimalMin(value = "1", message = "Product quantity cannot be less than 1")
    private long quantity;
}
