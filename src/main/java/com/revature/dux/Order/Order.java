package com.revature.dux.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revature.dux.Duck.Duck;
import com.revature.dux.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
// JPA
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "userId", nullable = false, name = "buyer")
    private User buyer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "userId", nullable = false, name = "seller")
    private User seller;
    @ManyToOne
    @JoinColumn(referencedColumnName = "duckId", nullable = false, name = "duck")
    private Duck duck;

    @Column(name = "order_date", columnDefinition = "default now()")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'CART'")
    private OrderStatus status;

    @Column(nullable = false, columnDefinition = "smallint default 1") // define constraints
    private short quantity;

    public enum OrderStatus {
        CART, PROCESSING, COMPLETE
    }

}