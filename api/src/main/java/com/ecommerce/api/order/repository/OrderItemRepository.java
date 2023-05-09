package com.ecommerce.api.order.repository;

import com.ecommerce.api.order.models.OrderItem;
import com.ecommerce.api.order.models.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem , OrderItemId> {
}
