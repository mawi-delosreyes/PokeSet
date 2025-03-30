package com.pokeset.service.impl;

import com.pokeset.dto.Team;
import com.pokeset.model.Response;
import com.pokeset.repository.TeamRepository;
import com.pokeset.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Response<Object> postRegisterTeam(Team team){
        Response response = new Response<>();

        try {
            teamRepository.save(team);
            response.setStatus("success");
            response.setMessage("Team has been saved");
        } catch (Exception e) {
            response.setStatus("error");
            response.setStatus(e.toString());
        }
        return response;
    }

    @Override
    public Response<Object> postEditTeam(Team team) {
        Response response = new Response<>();

        try {
            teamRepository.save(team);
            response.setStatus("success");
            response.setMessage("Team has been updated");
        } catch (Exception e) {
            response.setStatus("error");
            response.setStatus(e.toString());
        }
        return response;
    }
}
