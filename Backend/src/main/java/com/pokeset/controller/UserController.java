package com.pokeset.controller;

import com.pokeset.dto.User;
import com.pokeset.model.Response;
import com.pokeset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<Response> postRegiserUser(
            @RequestBody User user
    ) {
        Response response = userService.postRegisterUser(user);

        if (!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUser")
    public ResponseEntity<Response> getUser(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = true) String password
    ) {
        Response response =  userService.getUser(username, email, password);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
