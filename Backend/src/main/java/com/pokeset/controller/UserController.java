package com.pokeset.controller;

import com.pokeset.dto.User;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.UserResponse;
import com.pokeset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<BaseResponse> postRegiserUser(
            @RequestBody User user
    ) {
        BaseResponse response = userService.postRegisterUser(user);

        if (!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserResponse> getUser(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = true) String password
    ) {
        UserResponse response =  userService.getUser(username, email, password);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
