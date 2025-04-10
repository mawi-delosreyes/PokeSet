package com.pokeset.model;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonPresetRequestWrapper{
    private PokemonPreset pokemonPreset;
    private PokemonPresetDataModel pokemonPresetData;
    private PokemonEv pokemonEv;

    public PokemonPreset getPokemonPreset() {
        return pokemonPreset;
    }

    public void setPokemonPreset(PokemonPreset pokemonPreset) {
        this.pokemonPreset = pokemonPreset;
    }

    public PokemonPresetDataModel getPokemonPresetData() {
        return pokemonPresetData;
    }

    public void setPokemonPresetData(PokemonPresetDataModel pokemonPresetData) {
        this.pokemonPresetData = pokemonPresetData;
    }

    public PokemonEv getPokemonEv() {
        return pokemonEv;
    }

    public void setPokemonEv(PokemonEv pokemonEv) {
        this.pokemonEv = pokemonEv;
    }
}
