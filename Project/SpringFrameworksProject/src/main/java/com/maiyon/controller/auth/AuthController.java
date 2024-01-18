package com.maiyon.controller.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.request.UserRegister;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.User;
import com.maiyon.service.auth.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserRegister userRegister){
        if(userService.register(userRegister))
            return new ResponseEntity<>("Register successful.",HttpStatus.CREATED);
        return new ResponseEntity<>("Register failure.",HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
        UserResponse userResponse = userService.login(userLogin);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
