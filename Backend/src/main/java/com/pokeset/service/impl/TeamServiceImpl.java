package com.pokeset.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.*;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.PokemonPresetModel;
import com.pokeset.model.PokemonTeamPresetsModel;
import com.pokeset.model.TeamResponse;
import com.pokeset.repository.*;
import com.pokeset.service.TeamService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    PokemonListRepository pokemonListRepository;

    @Autowired
    private PokemonPresetRepository pokemonPresetRepository;

    @Autowired
    private PokemonPresetDataRepository pokemonPresetDataRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PokemonEvRepository pokemonEvRepository;

    public BaseResponse<Object> postRegisterTeam(Team team){
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_REGISTERED);
    }

    public BaseResponse<Object> postEditTeam(Team team) {
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_UPDATED);
    }

    public BaseResponse<Object> getTeamList(Integer userId, Boolean access){
        Optional<List> teamList = teamRepository.findAllByUserIdAndAccess(userId, access);

        if(!teamList.isEmpty()) {
            return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.AVAILABLE_POKEMON_LIST, Collections.singletonList(teamList));
        } else {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.UNAVAILABLE_POKEMON_LIST);
        }
    }

    @Override
    public TeamResponse<Object> getTeamInfo(Integer teamId, Integer userId, Boolean access) {
        PokemonTeamPresetsModel pokemonTeamPresetsModel = new PokemonTeamPresetsModel();

        Optional<Team> team_info = teamRepository.findTeamNameByTeamIdAndUserIdAndAccess(teamId, userId, access);
        if(team_info.isEmpty()) {
           return (TeamResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.TEAM_NOT_FOUND);
        }

        String teamName = team_info.get().getTeamName();
        Optional<List<PokemonPreset>> pokemon_presets = pokemonPresetRepository.findByTeamIdAndUserIdOrderByTeamArrange(teamId, userId);
        System.out.println(pokemon_presets.get());
        Integer num_preset = pokemon_presets.get().size();
        if (num_preset >= 1) {
            pokemonTeamPresetsModel.setPokemonPresetModel1(checkPresetExist(pokemon_presets.get().get(0)));
        }
        if (num_preset >= 2) {
            pokemonTeamPresetsModel.setPokemonPresetModel2(checkPresetExist(pokemon_presets.get().get(1)));
        }
        if (num_preset >= 3) {
            pokemonTeamPresetsModel.setPokemonPresetModel3(checkPresetExist(pokemon_presets.get().get(2)));
        }
        if (num_preset >= 4) {
            pokemonTeamPresetsModel.setPokemonPresetModel4(checkPresetExist(pokemon_presets.get().get(3)));
        }
        if (num_preset >= 5) {
            pokemonTeamPresetsModel.setPokemonPresetModel5(checkPresetExist(pokemon_presets.get().get(4)));
        }
        if (num_preset >= 6) {
            pokemonTeamPresetsModel.setPokemonPresetModel6(checkPresetExist(pokemon_presets.get().get(5)));
        }

        Optional<MatchDetails> matchDetails = matchRepository.findByTeamId(team_info.get().getTeamId());


        return (TeamResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_FOUND,
                teamName, teamId, userId, pokemonTeamPresetsModel, matchDetails.get());
    }

    private PokemonPresetModel checkPresetExist(PokemonPreset pokemonPreset) {
        PokemonPresetModel pokemonPresetModel = new PokemonPresetModel();

        List<Object[]> results = pokemonPresetDataRepository.findPresetsWithPokemonDetails(pokemonPreset.getPresetId());
        if (results == null || results.isEmpty()) {
            return null;
        }
        Object[] row = results.get(0);
        if (row != null) {
            pokemonPresetModel.setPresetId(((Number) row[0]).intValue());
            pokemonPresetModel.setPokemonId(((Number) row[1]).intValue());
            pokemonPresetModel.setPokemonName((String) row[2]);
            pokemonPresetModel.setPokemonType1((String) row[3]);
            pokemonPresetModel.setPokemonType2((String) row[4]);
            pokemonPresetModel.setNature((String) row[5]);
            pokemonPresetModel.setItem((String) row[6]);
            pokemonPresetModel.setAbility((String) row[7]);
            pokemonPresetModel.setBattleMechanic((String) row[8]);
            pokemonPresetModel.setType((String) row[9]);
            pokemonPresetModel.setPokemonURL(getSpriteUrl(((Number) row[1]).intValue()));
        }
        return pokemonPresetModel;
    }

    private String getSpriteUrl(Integer pokemonId) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String pokemonUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonId;
            String pokemonResponse = restTemplate.getForObject(pokemonUrl, String.class);
            Map<String, Object> pokemon = mapper.readValue(pokemonResponse, new TypeReference<>() {});
            Map<String, String> spriteList = (Map<String, String>) pokemon.get("sprites");
            return spriteList.get("front_default");
        } catch (Exception e) {
            return e.toString();
        }
    }
}
