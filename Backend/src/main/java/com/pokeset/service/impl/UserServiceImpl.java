package com.pokeset.service.impl;

import com.pokeset.dto.User;
import com.pokeset.model.Response;
import com.pokeset.repository.UserRepository;
import com.pokeset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Response<Object> postRegisterUser(User user){
        Response response;
        try {
            userRepository.save(user);
            response = new Response<Map>(
                    "success",
                    "User has been registered"
            );
        } catch (Exception e) {
            response = new Response<Map>(
                    "error",
                    e.toString()
            );
        }
        return response;
    }

    public Response<Object> getUser(String username, String email, String password) {
        Optional<User> user_data = userRepository.findByUsernameAndPassword(username, password);
        if(!username.isEmpty()) {
            user_data = userRepository.findByEmailAndPassword(email, password);
        }

        if(user_data.isEmpty()){
            Response response = new Response<Map>(
                    "error",
                    "No User found"
            );
            return response;
        }

        Map<String, String> user_info = new HashMap<>();
        user_info.put("user_id", user_data.get().getUserId().toString());
        user_info.put("username", user_data.get().getUsername());

        Response response = new Response<Map>(
                "success",
                "User found",
                user_info
        );

        return response;
    }
}
