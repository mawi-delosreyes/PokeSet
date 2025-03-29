package com.pokeset.model;

public class PokemonCardModel {
    private String teamName;
    private Integer teamId;
    private Integer presetId;
    private String pokemonName;
    private String pokemonType1;
    private String pokemonType2;
    private String nature;
    private String item;
    private String battleMechanic;
    private String battleMechanicType;
    private Integer teamArrange;

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

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
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

    public String getBattleMechanic() {
        return battleMechanic;
    }

    public void setBattleMechanic(String battleMechanic) {
        this.battleMechanic = battleMechanic;
    }

    public String getBattleMechanicType() {
        return battleMechanicType;
    }

    public void setBattleMechanicType(String battleMechanicType) {
        this.battleMechanicType = battleMechanicType;
    }

    public Integer getTeamArrange() {
        return teamArrange;
    }

    public void setTeamArrange(Integer teamArrange) {
        this.teamArrange = teamArrange;
    }
}
