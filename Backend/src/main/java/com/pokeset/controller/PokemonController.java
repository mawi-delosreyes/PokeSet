package com.pokeset.controller;

import com.pokeset.model.BaseResponse;
import com.pokeset.model.IndividualPresetResponse;
import com.pokeset.model.PokemonInfoResponse;
import com.pokeset.model.PokemonPresetRequestWrapper;
import com.pokeset.service.PokemonListService;
import com.pokeset.service.PokemonPresetService;
import com.pokeset.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonPresetService pokemonPresetService;

    @Autowired
    PokemonListService pokemonListService;

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/preset/register")
    public ResponseEntity postRegisterPokemonPreset(
            @RequestBody PokemonPresetRequestWrapper pokemonPresetRequestWrapper
    ){
        BaseResponse response = pokemonPresetService.postRegisterPokemonPreset(pokemonPresetRequestWrapper);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/preset/edit")
    public ResponseEntity postEditPokemonPreset(
            @RequestBody PokemonPresetRequestWrapper pokemonPresetRequestWrapper
    ){
        BaseResponse response = pokemonPresetService.postEditPokemonPreset(pokemonPresetRequestWrapper);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/presetData")
    public ResponseEntity getPokemonPreset(
            @RequestParam(required = true) Integer presetId
    ){
        IndividualPresetResponse response = pokemonPresetService.getPokemonPreset(presetId);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateList")
    public ResponseEntity updatePokemonList(
            @RequestBody Integer limit
    ) {
        BaseResponse response = pokemonListService.updatePokemonList(limit);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getList")
    public ResponseEntity getPokemonList(){
        BaseResponse response = pokemonListService.getPokemonList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPokemonInfo")
    public ResponseEntity getPokemonInfo(
            @RequestParam(required = true) Integer pokemonId
    ) {
        PokemonInfoResponse response = pokemonService.getPokemonInfo(pokemonId);
        return ResponseEntity.ok(response);
    }

}
