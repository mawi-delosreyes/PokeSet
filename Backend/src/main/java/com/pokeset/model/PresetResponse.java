package com.pokeset.model;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPresetData;

public class PresetResponse extends BaseResponse{

    private String presetName;
    private Integer pokemonId;
    private PokemonPresetData pokemonPresetData;
    private PokemonEv pokemonEv;

    public PresetResponse(String status, String message, String presetName, Integer pokemonId, PokemonPresetData pokemonPresetData, PokemonEv pokemonEv) {
        this.status = status;
        this.message = message;
        this.presetName = presetName;
        this.pokemonId = pokemonId;
        this.pokemonPresetData = pokemonPresetData;
        this.pokemonEv = pokemonEv;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

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
}
