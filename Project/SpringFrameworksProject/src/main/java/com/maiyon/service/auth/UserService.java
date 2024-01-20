package com.maiyon.service.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.request.UserRegister;
import com.maiyon.model.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean register(UserRegister user);
    UserResponse login(UserLogin userLogin);
}