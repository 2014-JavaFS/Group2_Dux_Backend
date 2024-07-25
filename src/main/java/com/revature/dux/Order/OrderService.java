package com.revature.dux.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.dux.util.interfaces.Serviceable;

import java.util.List;

@Service
public class OrderService implements Serviceable<Order>{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Order create(Order newObject) {
        return null;
    }

    @Override
    public Order findById(int number) {
        return null;
    }
}