package com.pokeset.model;

import java.util.ArrayList;

public class PresetList {
    private Integer pokemonId;
    private Integer userId;
    private ArrayList presetList;

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList getPresetList() {
        return presetList;
    }

    public void setPresetList(ArrayList presetList) {
        this.presetList = presetList;
    }
}
