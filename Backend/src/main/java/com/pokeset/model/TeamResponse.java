package com.pokeset.model;

import com.pokeset.dto.MatchDetails;

public class TeamResponse<T> extends BaseResponse {

    private String teamName;
    private Integer teamId;
    private Integer userId;
    private PokemonTeamPresetsModel pokemonTeamPresetsModel;
    private MatchDetails matchDetails;

    public TeamResponse(){}

    public TeamResponse(String status, String message, String teamName, Integer teamId, Integer userId,
                    PokemonTeamPresetsModel pokemonTeamPresetsModel, MatchDetails matchDetails) {
        this.status = status;
        this.message = message;
        this.teamName = teamName;
        this.teamId = teamId;
        this.userId = userId;
        this.pokemonTeamPresetsModel = pokemonTeamPresetsModel;
        this.matchDetails = matchDetails;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PokemonTeamPresetsModel getPokemonTeamPresetsModel() {
        return pokemonTeamPresetsModel;
    }

    public void setPokemonTeamPresetsModel(PokemonTeamPresetsModel pokemonTeamPresetsModel) {
        this.pokemonTeamPresetsModel = pokemonTeamPresetsModel;
    }

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public void setMatchDetails(MatchDetails matchDetails) {
        this.matchDetails = matchDetails;
    }
}
