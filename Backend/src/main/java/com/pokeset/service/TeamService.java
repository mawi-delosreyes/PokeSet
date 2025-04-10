package com.pokeset.service;

import com.pokeset.dto.Team;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.TeamResponse;

public interface TeamService {
    BaseResponse<Object> postRegisterTeam(Team team);
    BaseResponse<Object> postEditTeam(Team team);
    TeamResponse<Object> getTeam(Integer teamId, Integer userId, Boolean Access);
}
