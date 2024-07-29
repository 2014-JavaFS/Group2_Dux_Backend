package com.revature.dux.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revature.dux.Duck.Duck;
import com.revature.dux.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Reference;

import java.time.OffsetDateTime;

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
// JPA
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "userId", nullable = false)
    private User buyer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "userId", nullable = false)
    private User seller;
    @ManyToOne
    @JoinColumn(referencedColumnName = "duckId", nullable = false)
    private Duck duck;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime orderDate;
    private OrderStatus status;
    @Column(nullable = false, columnDefinition = "smallint default 1") // define constraints
    private short quantity;

    public enum OrderStatus {
        CART, PROCESSING, COMPLETE
    }

}