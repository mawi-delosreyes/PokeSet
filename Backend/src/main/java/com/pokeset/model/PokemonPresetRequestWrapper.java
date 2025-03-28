package com.pokeset.model;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonPresetRequestWrapper{
    private PokemonPreset pokemonPreset;
    private PokemonPresetData pokemonPresetData;
    private PokemonEv pokemonEv;

    public PokemonPreset getPokemonPreset() {
        return pokemonPreset;
    }

    public void setPokemonPreset(PokemonPreset pokemonPreset) {
        this.pokemonPreset = pokemonPreset;
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
