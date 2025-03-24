package com.pokeset.service.impl;

import com.pokeset.dto.User;
import com.pokeset.repository.UserRepository;
import com.pokeset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User postRegisterUser(User user){
        return userRepository.save(user);
    }

    public Map<String, String> getUser(String username, String email, String password) {

        Optional<User> user_data = userRepository.findByUsernameAndPassword(username, password);
        if(!username.isEmpty()) {
            user_data = userRepository.findByEmailAndPassword(email, password);
        }

        Map<String, String> user_info = new HashMap<>();
        user_info.put("user_id", null);
        user_info.put("username", null);

        if(user_data.isEmpty()) {
            user_info.put("status_code", HttpStatusCode.valueOf(204).toString());
            user_info.put("error", "No user found");
        }

        user_info.put("user_id", user_data.get().getUserId().toString());
        user_info.put("username", user_data.get().getUsername());
        user_info.put("status_code", HttpStatusCode.valueOf(200).toString());
        user_info.put("error", null);

        return user_info;
    }
}
