package com.pokeset.model;

import java.util.List;
import java.util.Map;

public class PokemonInfo {
    private String spriteUrl;
    private String description;
    private String type1;
    private String type2;
    private List weaknesses;
    private List<Map<String, String>> abilities;
    private Map<String, String> evolution;
    private List<Map<String, String>> moveList;
    private Map<String, Integer> statList;

    public String getSpriteUrl() {
        return spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public List getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<Map<String, String>> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Map<String, String>> abilities) {
        this.abilities = abilities;
    }

    public Map<String, String> getEvolution() {
        return evolution;
    }

    public void setEvolution(Map<String, String> evolution) {
        this.evolution = evolution;
    }

    public List<Map<String, String>> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Map<String, String>> moveList) {
        this.moveList = moveList;
    }

    public Map<String, Integer> getStatList() {
        return statList;
    }

    public void setStatList(Map<String, Integer> statList) {
        this.statList = statList;
    }

}
