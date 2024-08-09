package com.revature.dux.User;

import com.revature.dux.util.exceptions.InvalidInputException;
import com.revature.dux.util.interfaces.Serviceable;
import com.revature.dux.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@Service
public class UserService implements Serviceable<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public User findById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("Nothing in the database with user ID of " + userId));
    }

    @Override
    public User create(User newUser) {
        String rex = "\\w+@\\w+[\\.][com|org|net]{3}";
        if (!newUser.getEmail().matches(rex)) {
            throw new InvalidInputException("Invalid email format! Please ensure your email is properly formatted.");
        } else {
            return userRepository.save(newUser);
        }
    }

    public Boolean delete(User removedUser) {
        userRepository.delete(removedUser);
        return true;
    }

    public User findByEmailAndPassword(String email, String password) throws AuthenticationException {
        return userRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new AuthenticationException("Invalid credentials provided."));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new DataNotFoundException("no user with that username found"));
    }

    public Boolean update(User updatedUser) {

        userRepository.save(updatedUser);
        return true;
    }
}