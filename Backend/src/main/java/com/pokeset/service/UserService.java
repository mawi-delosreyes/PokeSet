package com.pokeset.service;

import com.pokeset.dto.User;

import java.util.Map;

public interface UserService {
    User postRegisterUser(User user);
    Map<String, String> getUser(String username, String email, String password);
}
