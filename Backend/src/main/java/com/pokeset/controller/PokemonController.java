package com.pokeset.controller;

import com.pokeset.model.PokemonPresetRequestWrapper;
import com.pokeset.model.Response;
import com.pokeset.service.PokemonPresetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonPresetService pokemonPresetService;

    @PostMapping("/preset/register")
    public ResponseEntity postRegisterPokemonPreset(
            @RequestBody PokemonPresetRequestWrapper pokemonPresetRequestWrapper
    ){
        Response response = pokemonPresetService.postRegisterPokemonPreset(pokemonPresetRequestWrapper);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/preset/edit")
    public ResponseEntity postEditPokemonPreset(
            @RequestBody PokemonPresetRequestWrapper pokemonPresetRequestWrapper
    ){
        Response response = pokemonPresetService.postEditPokemonPreset(pokemonPresetRequestWrapper);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/presetData")
    public ResponseEntity getPokemonPreset(
            @RequestParam(required = true) Integer presetId
    ){
        Response response = pokemonPresetService.getPokemonPreset(presetId);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allPresets")
    public ResponseEntity getAllPresets(
            @RequestParam(required = true) Integer userId,
            @RequestParam(required = true) Integer pokemonId
    ){
        Response response = pokemonPresetService.getAllPokemonPreset(userId, pokemonId);

        if(!response.getStatus().equals("success")){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
