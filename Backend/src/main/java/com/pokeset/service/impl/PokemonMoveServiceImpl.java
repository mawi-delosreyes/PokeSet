package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonMoves;
import com.pokeset.model.PokemonMovesModel;
import com.pokeset.model.Response;
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

    public Response<Object> postRegisterPokemonMove(PokemonMovesModel pokemonMoves) {
        try{
            if(pokemonMoves.getMove1() == null) {
                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove1().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove1().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove1().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            } else {
                Optional<PokemonMoves> move1 = pokemonMoveRepository.findByMoveName(pokemonMoves.getMove1().getMoveName());
                if(!move1.isEmpty()) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.MOVE_EXISTING);
                }

                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove1().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove1().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove1().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            }

            if(pokemonMoves.getMove2() == null) {
                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove2().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove2().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove2().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            } else {
                Optional<PokemonMoves> move2 = pokemonMoveRepository.findByMoveName(pokemonMoves.getMove2().getMoveName());
                if(!move2.isEmpty()) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.MOVE_EXISTING);
                }

                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove2().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove2().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove2().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            }

            if(pokemonMoves.getMove3() == null) {
                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove3().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove3().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove3().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            } else {
                Optional<PokemonMoves> move3 = pokemonMoveRepository.findByMoveName(pokemonMoves.getMove3().getMoveName());
                if(!move3.isEmpty()) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.MOVE_EXISTING);
                }

                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove3().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove3().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove3().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            }

            if(pokemonMoves.getMove4() == null) {
                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove4().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove4().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove4().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            } else {
                Optional<PokemonMoves> move4 = pokemonMoveRepository.findByMoveName(pokemonMoves.getMove4().getMoveName());
                if(!move4.isEmpty()) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.MOVE_EXISTING);
                }

                try {
                    PokemonMoves pokemonMove = new PokemonMoves();
                    pokemonMove.setMoveName(pokemonMoves.getMove4().getMoveName());
                    pokemonMove.setType1(pokemonMoves.getMove4().getType_1());
                    pokemonMove.setType2(pokemonMoves.getMove4().getType_2());
                    pokemonMoveRepository.save(pokemonMove);
                } catch (Exception e) {
                    return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
                }
            }
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.MOVE_REGISTERED);
    }
}
