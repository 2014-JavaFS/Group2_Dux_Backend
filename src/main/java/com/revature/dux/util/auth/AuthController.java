package com.revature.dux.util.auth;

import com.revature.dux.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController  {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    private RedirectView getRedirect() {
        String url = "https://i.pinimg.com/736x/6a/6d/11/6a6d1124cf69e5588588bc7e397598f6.jpg";
        return new RedirectView(url);
    }

    @PostMapping
    private ResponseEntity<Void> postLogin(@RequestParam String email, @RequestParam String password) throws AuthenticationException {
//        User user = authService.login(email, password);
//        return ResponseEntity.noContent()
//                .header("userId", String.valueOf(user.getUserId()))
//                .build();
        return null;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleAuthenticationException(AuthenticationException ae){
        return ae.getMessage();
    }
}
