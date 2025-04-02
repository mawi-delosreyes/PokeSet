package com.pokeset.model;

import com.pokeset.dto.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamModel extends Team {

    private HashMap<String, Map> pokemonPresets;
    private HashMap<String, Map> matches;

    public HashMap<String, Map> getPokemonPresets() {
        return pokemonPresets;
    }

    public void setPokemonPresets(HashMap<String, Map> pokemonPresets) {
        this.pokemonPresets = pokemonPresets;
    }

    public HashMap<String, Map> getMatches() {
        return matches;
    }

    public void setMatches(HashMap<String, Map> matches) {
        this.matches = matches;
    }
}
