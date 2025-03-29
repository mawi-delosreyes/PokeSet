package com.pokeset.controller;

import com.pokeset.dto.MatchDetails;
import com.pokeset.model.MatchRequestWrapper;
import com.pokeset.model.Response;
import com.pokeset.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping("/register")
    public ResponseEntity postRegisterMatchDetail(
            @RequestBody MatchRequestWrapper matchRequestWrapper
    ){
        Response response = matchService.postRegisterMatch(matchRequestWrapper);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
