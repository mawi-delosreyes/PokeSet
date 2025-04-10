package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonMoves;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.PokemonMovesModel;
import com.pokeset.repository.PokemonMoveRepository;
import com.pokeset.service.PokemonMoveService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonMoveServiceImpl implements PokemonMoveService {

    @Autowired
    PokemonMoveRepository pokemonMoveRepository;

    public BaseResponse<Object> postRegisterPokemonMove(PokemonMovesModel pokemonMoves) {

        try {
            addEditMove(pokemonMoves.getMove1());
            addEditMove(pokemonMoves.getMove2());
            addEditMove(pokemonMoves.getMove3());
            addEditMove(pokemonMoves.getMove4());
        } catch(Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.MOVE_REGISTERED);
    }

    private void addEditMove(PokemonMoves pokemonMoves){

        if(pokemonMoves == null) {
            pokemonMoveRepository.save(pokemonMoves);
        } else {
            Optional<PokemonMoves> move = pokemonMoveRepository.findByMoveName(pokemonMoves.getMoveName());
            pokemonMoves.setMoveId(move.get().getMoveId());
            pokemonMoveRepository.save(pokemonMoves);
        }
    }
}
