package com.pokeset.model;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPresetData;

public class IndividualPresetModel {
    private PokemonEv pokemonEv;
    private PokemonPresetData pokemonPresetData;
    private Integer presetId;
    private String presetName;

    public PokemonPresetData getPokemonPresetData() {
        return pokemonPresetData;
    }

    public void setPokemonPresetData(PokemonPresetData pokemonPresetData) {
        this.pokemonPresetData = pokemonPresetData;
    }

    public PokemonEv getPokemonEv() {
        return pokemonEv;
    }

    public void setPokemonEv(PokemonEv pokemonEv) {
        this.pokemonEv = pokemonEv;
    }

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }
}
