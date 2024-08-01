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

    /*
    TODO CART Endpoints and planning : Ethan - member of the High Mallard Council
    -  might need to add a deleted status to order status?

    // when creating an order probably need to default their status to in a cart right?
    @PostMapping
    private ResponseEntity<Order> postNewOrder(@RequestBody Order newOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(newOrder));
    }
    //Used to see the cart of the current user
    @GetMapping({"userID"})
    private ResponseEntity<List<Order>> findAllOrdersForUser(@PathVariable int userID) {// also not sure if this is the input param we want
        return ResponseEntity.ok().body(orderService.findAllByUser(userID)); // -> This needs to be implemented in OrderService as well
    }

    // I did plan a remove function to make sure this function only has one use case, but this cna be changed to a generic update status for orders
    //since we are only partially updating a resource we use patch...right?
    @PatchMapping({"orderID"})
    private ResponseEntity<Order> removeOrderFromCart(@PathVariable int orderID) {
        return ResponseEntity.ok().body(orderService.removeOrderFromCart(orderID)); // -> This needs to be implemented in OrderService as well
    }
    */
}