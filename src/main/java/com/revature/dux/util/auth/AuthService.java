package com.revature.dux.util.auth;

import com.revature.dux.User.User;
import org.springframework.stereotype.Service;
//import com.revature.dux.User.UserService;
import javax.security.sasl.AuthenticationException;

/**
 * Authentication Service to check our member database for matching information based on users input. Separated for
 * security concerns. REQUIRES MemberService to be injected.
 *
 *
 */
@Service
public class AuthService {
//    private final UserService userService; // Assuming a MemberService instance
//
//    public AuthService(UserService userService) {
//        this.userService = userService;
//    }
//
//    public User login(String email, String password) throws AuthenticationException {
//        User user = userService.findByEmailAndPassword(email, password);
//        if(user == null) throw new AuthenticationException("Invalid member credentials, please try again");
//        return user;
//    }
}
