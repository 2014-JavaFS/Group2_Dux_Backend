package com.revature.dux.Order;

import com.revature.dux.Duck.Duck;
import com.revature.dux.User.User;

import java.time.OffsetDateTime;

public class Order {
    private int orderId;
    private User buyer;
    private User seller;
    private Duck duck;
    private OffsetDateTime orderDate;
    private OrderStatus status;
    private short quantity;

    public enum OrderStatus {
        CART, PROCESSING, COMPLETE
    }

    public Order() {
    }

    public Order(int orderId, User buyer, User seller, Duck duck, OffsetDateTime orderDate, OrderStatus status, short quantity) {
        this.orderId = orderId;
        this.buyer = buyer;
        this.seller = seller;
        this.duck = duck;
        this.orderDate = orderDate;
        this.status = status;
        this.quantity = quantity;
    }

    public int getOrderId() { return this.orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }

    public User getBuyer() { return this.buyer; }

    public void setBuyer(User buyer) { this.buyer = buyer; }

    public User getSeller() { return this.seller; }

    public void setSeller(User seller) { this.seller = seller; }

    public Duck getDuck() { return this.duck; }

    public void setDuck(Duck duck) { this.duck = duck; }

    public OffsetDateTime getOrderDate() { return this.orderDate; }

    public void setOrderDate(OffsetDateTime orderDate) { this.orderDate = orderDate; }

    public OrderStatus getStatus() { return this.status; }

    public void setStatus(OrderStatus status) { this.status = status; }

    public short getQuantity() { return this.quantity; }

    public void setQuantity(short quantity) { this.quantity = quantity; }
}