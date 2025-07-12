package com.pokeset.model;

import java.util.List;

public class PokemonListResponse<T> extends BaseResponse {

    private List pokemonList;

    public PokemonListResponse(){}

    public PokemonListResponse(String status, String message, List pokemonList){
        this.status = status;
        this.message = message;
        this.pokemonList = pokemonList;
    }

    public List getPokemonList(){
        return pokemonList;
    }

    public void setPokemonList(List pokemonList){
        this.pokemonList = pokemonList;
    }
}
