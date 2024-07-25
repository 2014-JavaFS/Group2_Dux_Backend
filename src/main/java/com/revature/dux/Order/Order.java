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
    @JoinColumn(name = "userId")
    @Column(nullable = false)
    private int buyer;
    @ManyToOne
    @JoinColumn(name = "userId")
    private int seller;
    @ManyToOne
    @JoinColumn(name = "duckId")
    @Column(nullable = false)
    private int duck;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime orderDate;
    private OrderStatus status;
    @Column(nullable = false, columnDefinition = "default '1'")
    private short quantity;

    public enum OrderStatus {
        CART, PROCESSING, COMPLETE
    }

}