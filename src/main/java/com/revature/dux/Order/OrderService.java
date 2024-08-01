package com.revature.dux.Order;

import com.revature.dux.util.exceptions.DataNotFoundException;
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
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public Order findById(int number) {
        return orderRepository.findById(number).orElseThrow(() -> new DataNotFoundException("no order with that id"));
    }

    @Override
    public Boolean update(Order updatedObject) {
        orderRepository.save(updatedObject);
        return true;
    }
    @Override
    public Boolean delete(Order deletedObject) {
        orderRepository.delete(deletedObject);
        return true;
    }
    //will need to add validation to most of these methods
    public Boolean removeOrderFromCartByID(int id){
        Order orderToUpdate = findById(id);
        orderRepository.delete(orderToUpdate);
        return true;
    }
}