package com.maiyon.controller.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.User;
import com.maiyon.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user){
        User userNew = userService.register(user);
        if(userNew != null){
            return new ResponseEntity<>("Register successful.",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Register failure.",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
        UserResponse userResponse = userService.login(userLogin);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
