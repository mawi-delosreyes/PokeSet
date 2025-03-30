package com.pokeset.service;

import com.pokeset.model.PokemonPresetRequestWrapper;
import com.pokeset.model.Response;

public interface PokemonPresetService {
    Response<Object> postRegisterPokemonPreset(PokemonPresetRequestWrapper PokemonPresetRequestWrapper);
    Response<Object> postEditPokemonPreset(PokemonPresetRequestWrapper PokemonPresetRequestWrapper);
    Response<Object> getPokemonPreset(Integer presetId);
    Response<Object> getAllPokemonPreset(Integer userId, Integer pokemonId);
}
