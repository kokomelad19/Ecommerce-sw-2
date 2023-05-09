package com.ecommerce.api.order.dto.output;

import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.order.models.OrderItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private OrderItemId id;

    private ProductDto product;

    private long quantity;

    private BigDecimal unitPrice;
}
