package com.maiyon.service.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.request.UserRegister;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.User;

import java.util.Optional;

public interface UserService {
    Boolean register(UserRegister user);
    UserResponse login(UserLogin userLogin);
}
