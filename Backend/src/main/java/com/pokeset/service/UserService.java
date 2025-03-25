package com.pokeset.service;

import com.pokeset.dto.User;
import com.pokeset.model.Response;

import java.util.Map;

public interface UserService {
    Response<Object> postRegisterUser(User user);
    Response<Object> getUser(String username, String email, String password);
}
