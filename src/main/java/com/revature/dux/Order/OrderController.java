package com.revature.dux.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    //this one still kind broken
    @PostMapping
    private ResponseEntity<Order> postNewOrder(@RequestBody Order newOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(newOrder));
    }

    @GetMapping
    private ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Order> findOrderById(@PathVariable int id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    // I do need to change this to a @RequestHeader and grab the user Id that is logged in
    // but we do not have that functionality yet so I am putting this in for testing purposes
    @GetMapping("/getbyUser/{userId}")
    private ResponseEntity<List<Order>> findAllOrdersForUser(@PathVariable int userId) {
        return ResponseEntity.ok().body(orderService.findAllByUser(userId)); // -> This needs to be implemented in OrderService as well
    }

    @DeleteMapping({"/{orderID}"})
    private ResponseEntity<Void> removeOrderFromCart(@PathVariable int orderID) {
        if(orderService.removeOrderFromCartByID(orderID)){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
}