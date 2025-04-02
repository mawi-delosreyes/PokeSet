package com.pokeset.model;

public class Response<T> {
    private String status;
    private String message;
    private T data;
    private String teamName;
    private Integer teamId;
    private Integer userId;
    private PokemonPresetDataModel pokemonPresetData;
    private EvModel pokemonEv;

    public Response(String status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(String status, String message){
        this.status = status;
        this.message = message;
    }

    public Response(){}

    public Response(String status, String message, String teamName, Integer teamId, Integer userId, PokemonPresetDataModel pokemonPresetData, EvModel pokemonEv){
        this.status = status;
        this.message = message;
        this.teamName = teamName;
        this.teamId = teamId;
        this.userId = userId;
        this.pokemonPresetData = pokemonPresetData;
        this.pokemonEv = pokemonEv;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
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

    public PokemonPresetDataModel getPokemonPresetData() {
        return pokemonPresetData;
    }

    public void setPokemonPresetData(PokemonPresetDataModel pokemonPresetData) {
        this.pokemonPresetData = pokemonPresetData;
    }

    public EvModel getPokemonEv() {
        return pokemonEv;
    }

    public void setPokemonEv(EvModel pokemonEv) {
        this.pokemonEv = pokemonEv;
    }
}
