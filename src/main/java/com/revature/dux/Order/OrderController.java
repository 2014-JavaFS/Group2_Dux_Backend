package com.revature.dux.Order;

import com.revature.dux.Duck.Duck;
import com.revature.dux.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // when creating an order probably need to default their status to in a cart right?
    @PostMapping
    private ResponseEntity<Order> postNewOrder(@RequestBody Order newOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(newOrder));
    }
    /*
    //Used to see the cart of the current user, this is probably why we wanted a cart controller in the first place
    // need to look up how to grab information from headers and grab the current logged in User
    @GetMapping({"userID"})
    private ResponseEntity<List<Order>> findAllOrdersForUser(@PathVariable int userID) {// also not sure if this is the input param we want
        return ResponseEntity.ok().body(orderService.findAllByUser(userID)); // -> This needs to be implemented in OrderService as well
    }
    */
    @DeleteMapping({"orderID"})
    private ResponseEntity<Void> removeOrderFromCart(@PathVariable int orderID) {
        if(orderService.removeOrderFromCartByID(orderID)){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
}