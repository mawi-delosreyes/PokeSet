package com.pokeset.service;

import com.pokeset.dto.User;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.UserResponse;

public interface UserService {
    BaseResponse<Object> postRegisterUser(User user);
    UserResponse<Object> getUser(String username, String email, String password);
}
