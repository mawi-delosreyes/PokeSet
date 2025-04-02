package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.dto.Team;
import com.pokeset.model.PokemonPresetDataModel;
import com.pokeset.model.Response;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonPresetDataRepository;
import com.pokeset.repository.PokemonPresetRepository;
import com.pokeset.repository.TeamRepository;
import com.pokeset.service.TeamService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PokemonPresetRepository pokemonPresetRepository;

    @Autowired
    private PokemonPresetDataRepository pokemonPresetDataRepository;

    @Autowired
    private PokemonEvRepository pokemonEvRepository;

    public Response<Object> postRegisterTeam(Team team){
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_REGISTERED);
    }

    public Response<Object> postEditTeam(Team team) {
        Response response = new Response<>();

        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_UPDATED);
    }

    public Response<Object> getTeam(Team team) {
        Response response = new Response();

        PokemonPresetDataModel pokemon_preset_data_model = new PokemonPresetDataModel();

        Optional<Team> team_info = teamRepository.findTeamNameByTeamIdAndUserIdAndAccess(team.getTeamId(), team.getUserId(), team.isAccess());
        if(team_info.isEmpty()) {
           return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.TEAM_NOT_FOUND);
        }

        response.setTeamName(team_info.get().getTeamName());
        response.setTeamId(team.getTeamId());
        response.setUserId(team.getUserId());

        Optional<PokemonPreset> pokemon_preset = pokemonPresetRepository.findByTeamId(team.getTeamId());
        if(pokemon_preset.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_NOT_FOUND);
        }

        Optional<PokemonPresetData> pokemon_preset_data = pokemonPresetDataRepository.findByPresetId(pokemon_preset.get().getPresetId());
        if(pokemon_preset_data.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_DATA_NOT_FOUND);
        }

        Optional<PokemonEv> pokemon_ev = pokemonEvRepository.findByEvId(pokemon_preset_data.get().getEvId());
        if(pokemon_ev.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.EV_NOT_FOUND);
        }

        return response;

    }
}
