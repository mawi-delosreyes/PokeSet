package com.pokeset.model;

import com.pokeset.dto.PokemonEv;

public class PokemonPresetModel {
    private Integer presetId;
    private Integer pokemonId;
    private String pokemonURL;
    private String pokemonName;
    private String pokemonType1;
    private String pokemonType2;
    private String nature;
    private String item;
    private String ability;
    private String battleMechanic;
    private String type;
    private PokemonMovesModel pokemonMovesModel;
    private PokemonEv pokemonEv;

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonURL() {
       return pokemonURL;
    }

    public void setPokemonURL(String pokemonURL) {
        this.pokemonURL = pokemonURL;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonType1() {
        return pokemonType1;
    }

    public void setPokemonType1(String pokemonType1) {
        this.pokemonType1 = pokemonType1;
    }

    public String getPokemonType2() {
        return pokemonType2;
    }

    public void setPokemonType2(String pokemonType2) {
        this.pokemonType2 = pokemonType2;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getBattleMechanic() {
        return battleMechanic;
    }

    public void setBattleMechanic(String battleMechanic) {
        this.battleMechanic = battleMechanic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PokemonMovesModel getPokemonMovesModel() {
        return pokemonMovesModel;
    }

    public void setPokemonMovesModel(PokemonMovesModel pokemonMovesModel) {
        this.pokemonMovesModel = pokemonMovesModel;
    }

    public PokemonEv getPokemonEv() {
        return pokemonEv;
    }

    public void setPokemonEv(PokemonEv pokemonEv) {
        this.pokemonEv = pokemonEv;
    }
}
