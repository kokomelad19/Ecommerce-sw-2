package com.ecommerce.api.cart.models;

import com.ecommerce.api.users.models.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CartItem> cartItems;
}

