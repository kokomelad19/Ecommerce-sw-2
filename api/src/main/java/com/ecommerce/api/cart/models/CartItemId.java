package com.ecommerce.api.cart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemId implements Serializable {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CartItemId)) return false;
        CartItemId cartItemId = (CartItemId) object;
        return Objects.equals(getCartId(), cartItemId.getCartId()) &&
                Objects.equals(getProductId(), cartItemId.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getProductId());
    }
}

