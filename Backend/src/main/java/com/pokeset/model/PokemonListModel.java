package com.pokeset.model;

import com.pokeset.dto.PokemonList;

public class PokemonListModel {

    private Integer pokemonId;
    private String pokemonName;
    private String type1;
    private String type2;

    public Integer getPokemonId(){
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId){
        this.pokemonId = pokemonId;
    }

    public String getPokemonName(){
        return pokemonName;
    }

    public void setPokemonName(String pokemonName){
        this.pokemonName = pokemonName;
    }

    public String getType1(){
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2(){
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
}
