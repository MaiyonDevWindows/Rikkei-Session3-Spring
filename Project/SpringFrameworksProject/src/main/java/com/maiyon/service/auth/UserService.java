package com.maiyon.service.auth;

import com.maiyon.model.dto.request.UserLogin;
import com.maiyon.model.dto.response.UserResponse;
import com.maiyon.model.entity.User;

public interface UserService {
    User register(User user);
    UserResponse login(UserLogin userLogin);
}
