package com.pokeset.service.impl;

import com.pokeset.dto.Team;
import com.pokeset.repository.TeamRepository;
import com.pokeset.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team postRegisterTeam(Team team){
        return teamRepository.save(team);
    }
}
