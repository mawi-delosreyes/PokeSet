package com.pokeset.model;

public class PokemonPresetDataModel {
    private PokemonMovesModel moves;
    private String item;
    private String nature;
    private String ability;
    private String battleMechanic;
    private String type;
    private Boolean used;

    public PokemonMovesModel getMoves() {
        return moves;
    }

    public void setMoves(PokemonMovesModel pokemonMovesModel) {
        this.moves = pokemonMovesModel;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
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

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}
