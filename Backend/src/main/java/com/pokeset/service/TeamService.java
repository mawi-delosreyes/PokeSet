package com.pokeset.service;

import com.pokeset.dto.Team;
import com.pokeset.model.Response;

public interface TeamService {
    Response<Object> postRegisterTeam(Team team);
    Response<Object> postEditTeam(Team team);
    Response<Object> getTeam(Team team);
}
