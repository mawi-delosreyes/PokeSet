package com.pokeset.service;

import com.pokeset.model.BaseResponse;

public interface PokemonListService {
    BaseResponse<Object> updatePokemonList();
    BaseResponse<Object> getPokemonList();
}

