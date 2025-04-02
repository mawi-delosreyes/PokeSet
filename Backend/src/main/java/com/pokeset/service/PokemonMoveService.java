package com.pokeset.service;

import com.pokeset.model.PokemonMovesModel;
import com.pokeset.model.Response;

public interface PokemonMoveService {
    Response<Object> postRegisterPokemonMove(PokemonMovesModel pokemonMovesModel);
}
