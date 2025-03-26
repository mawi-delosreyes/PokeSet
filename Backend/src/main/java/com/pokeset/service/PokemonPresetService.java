package com.pokeset.service;

import com.pokeset.dto.PokemonPreset;
import com.pokeset.model.Response;

public interface PokemonPresetService {
    Response<Object> postRegisterPokemonPreset(PokemonPreset pokemonPreset);
    Response<Object> getPokemonPreset(Integer presetId);
    Response<Object> getAllPokemonPreset(Integer userId, Integer pokemonId);
}
