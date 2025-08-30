package com.pokeset.util;

import com.pokeset.dto.MatchDetails;
import com.pokeset.model.*;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ResponseUtil {

    public BaseResponse generatedResponse(String status, String message) {
        BaseResponse response = new BaseResponse();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }

    public UserResponse generatedResponse(String status, String message, String username, Integer userId, String email) {
        UserResponse response = new UserResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setUsername(username);
        response.setUserId(userId);
        response.setEmail(email);
        return response;
    }

    public IndividualPresetResponse generatedResponse(String status, String message, IndividualPresetModel individualPresetModel){
        IndividualPresetResponse response = new IndividualPresetResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setIndividualPresetModel(individualPresetModel);
        return response;
    }

    public TeamResponse generatedResponse(String status, String message, String teamName, Integer teamId, Integer userId,
                                      PokemonTeamPresetsModel pokemonTeamPresetsModel, MatchDetails matchDetails) {
        TeamResponse response = new TeamResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setTeamName(teamName);
        response.setTeamId(teamId);
        response.setUserId(userId);
        response.setPokemonTeamPresetsModel(pokemonTeamPresetsModel);
        response.setMatchDetails(matchDetails);
        return response;
    }

    public PokemonListResponse generatedResponse(String status, String message, List pokemonList){
        PokemonListResponse response = new PokemonListResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setPokemonList(pokemonList);

        return response;
    }

    public PokemonInfoResponse<PokemonInfo> generatePokemonResponse(String status, String message, PokemonInfo pokemonInfo) {
        PokemonInfoResponse<PokemonInfo> response = new PokemonInfoResponse<>();
        response.setStatus(status);
        response.setMessage(message);
        response.setPokemonInfo(pokemonInfo);
        return response;
    }

    public PokemonInfoResponse<PokemonInfo> generatePokemonResponse(String status, String message) {
        PokemonInfoResponse<PokemonInfo> response = new PokemonInfoResponse<>();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }

}
