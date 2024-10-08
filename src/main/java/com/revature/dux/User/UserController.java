package com.revature.dux.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

//might have to change depending on port the react app launches with (Vite will tell you the port)
@CrossOrigin(exposedHeaders = {"userId"}, origins = "http://localhost:5173/",allowedHeaders = {"userid"})
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    private ResponseEntity<List<User>> findAllUsers() { return ResponseEntity.ok().body(userService.findAll()); }

    @GetMapping("/{username}")
    private ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }
    @GetMapping("/showProfile")
    private ResponseEntity<User> findUserById(@RequestHeader("userid") String userString){
        int userInt = Integer.parseInt(userString);
        return ResponseEntity.ok().body(userService.findById(userInt));
    }

    @PostMapping
    private ResponseEntity<User> postNewUser(@RequestBody User newUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(newUser));
    }

    @PutMapping
    private ResponseEntity<Boolean> putUpdateDuck(@RequestBody User updateUser) {
        return ResponseEntity.ok(userService.update(updateUser));
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteUser(@RequestBody User user) {
        userService.delete(user);
        return ResponseEntity.noContent().build();
    }
}