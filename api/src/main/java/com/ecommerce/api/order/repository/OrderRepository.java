package com.ecommerce.api.order.repository;

import com.ecommerce.api.order.models.Order;
import com.ecommerce.api.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
    public List<Order> findByUser(User user);

    public Optional<Order> findByIdAndUser(Long id , User user);
}
