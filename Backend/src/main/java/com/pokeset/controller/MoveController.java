package com.pokeset.controller;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.PokemonMovesModel;
import com.pokeset.service.PokemonMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/move")
public class MoveController {

    @Autowired
    PokemonMoveService pokemonMoveService;

    @PostMapping("/register")
    public ResponseEntity postRegisterMove(
            @RequestBody PokemonMovesModel pokemonMovesModel
    ){
        BaseResponse response = pokemonMoveService.postRegisterPokemonMove(pokemonMovesModel);

        if(!response.getStatus().equals(ResponseConstants.SUCCESS)) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

}
