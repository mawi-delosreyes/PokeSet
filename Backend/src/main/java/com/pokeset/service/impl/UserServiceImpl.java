package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.User;
import com.pokeset.model.Response;
import com.pokeset.repository.UserRepository;
import com.pokeset.service.UserService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Response<Object> postRegisterUser(User user){
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.USER_REGISTERED);
    }

    public Response<Object> getUser(String username, String email, String password) {
        Optional<User> user_data = Optional.empty();
        if(username != null) {
            user_data= userRepository.findByUsernameAndPassword(username, password);
        }
        else if (email != null) {
            user_data = userRepository.findByEmailAndPassword(email, password);
        }

        if(user_data.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.USER_NOT_FOUND);
        }

        HashMap<String, String> user_info = new HashMap<>();
        user_info.put("user_id", user_data.get().getUserId().toString());
        user_info.put("username", user_data.get().getUsername());

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.USER_FOUND, user_info);
    }
}
