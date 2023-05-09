package com.ecommerce.api.cart.dto.output;

import com.ecommerce.api.cart.models.CartItemId;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsDto {
    private CartItemId id;

    private ProductDto product;

    private long quantity;
}
