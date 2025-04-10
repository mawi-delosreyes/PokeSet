package com.pokeset.service;

import com.pokeset.model.PokemonMovesModel;
import com.pokeset.model.BaseResponse;

public interface PokemonMoveService {
    BaseResponse<Object> postRegisterPokemonMove(PokemonMovesModel pokemonMovesModel);
}
