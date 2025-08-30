package com.pokeset.model;

public class PokemonInfoResponse <T> extends BaseResponse{

    private PokemonInfo pokemonInfo;

    public PokemonInfoResponse(){}

    public PokemonInfoResponse(String status, String message, PokemonInfo pokemonInfo) {
        this.status = status;
        this.message = message;
        this.pokemonInfo = pokemonInfo;
    }

    public PokemonInfo getPokemonInfo() {
        return pokemonInfo;
    }

    public void setPokemonInfo(PokemonInfo pokemonInfo) {
        this.pokemonInfo = pokemonInfo;
    }
}
