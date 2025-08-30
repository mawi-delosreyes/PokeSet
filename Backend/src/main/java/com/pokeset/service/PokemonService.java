package com.pokeset.service;

import com.pokeset.model.PokemonInfo;
import com.pokeset.model.PokemonInfoResponse;

public interface PokemonService {
    PokemonInfoResponse<PokemonInfo> getPokemonInfo(Integer PokemonId);
}
