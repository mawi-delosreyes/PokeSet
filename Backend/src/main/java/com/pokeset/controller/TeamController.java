package com.pokeset.controller;

import com.pokeset.dto.Team;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.TeamResponse;
import com.pokeset.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping("register")
    public ResponseEntity postRegisterTeam(
            @RequestBody Team team
    ){
        BaseResponse response = teamService.postRegisterTeam(team);

        if (!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("edit")
    public ResponseEntity postEditTeam(
            @RequestBody Team team
    ){
        BaseResponse response = teamService.postEditTeam(team);

        if (!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTeam")
    public ResponseEntity<TeamResponse> getTeam(
            @RequestParam(required = false) Integer teamId,
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = true) Boolean access
    ) {
        TeamResponse response =  teamService.getTeam(teamId, userId, access);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }

}
