package com.revature.dux.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//might have to change depending on port the react app launches with (Vite will tell you the port)
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //this one still kind broken
    @PostMapping
    private ResponseEntity<Order> postNewOrder(@RequestBody Order newOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(newOrder));
    }

    @PostMapping("/addToCart")
    private ResponseEntity<Boolean> postAddToCart(@RequestParam int buyer,@RequestParam int seller,@RequestParam int duck,@RequestParam int quantity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.generateOrder(buyer, seller, duck, quantity));
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
    @GetMapping("/getBySeller/{userId}")
    private ResponseEntity<List<Order>> findAllOrdersBySeller(@PathVariable int userId) {
        return ResponseEntity.ok().body(orderService.findAllBySeller(userId));
    }

    @GetMapping("/getByBuyer/{userId}")
    private ResponseEntity<List<Order>> findAllOrdersByBuyer(@PathVariable int userId) {
        return ResponseEntity.ok().body(orderService.findAllByBuyer(userId));
    }

    @GetMapping("/cart")
    private ResponseEntity<List<Order>> getCart(@RequestParam int userId){
        return ResponseEntity.ok(orderService.getCart(userId));
    }

    @PatchMapping("/checkout")
    private ResponseEntity<String> patchCheckout(@RequestParam int userId) {
        int rowsUpdated = orderService.checkout(userId);
        if (rowsUpdated > 0) return ResponseEntity.ok("rows updated: " + rowsUpdated);
        else return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }

    @GetMapping("/history")
    private ResponseEntity<List<Order>> getHistory(@RequestParam int userId){
        return ResponseEntity.ok(orderService.getHistory(userId));
    }

    @DeleteMapping({"/{orderID}"})
    private ResponseEntity<Void> removeOrderFromCart(@PathVariable int orderId) {
        if (orderService.removeOrderFromCartByID(orderId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
}