package com.pokeset.service.impl;

import com.pokeset.dto.Team;
import com.pokeset.model.Response;
import com.pokeset.repository.TeamRepository;
import com.pokeset.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Response<Object> postRegisterTeam(Team team){
        Response response;
        try {
            teamRepository.save(team);
            response = new Response<Map>(
                    "success",
                    "Team has been saved"
            );
        } catch (Exception e) {
            response = new Response<Map>(
                    "error",
                    e.toString()
            );
        }
        return response;
    }
}
