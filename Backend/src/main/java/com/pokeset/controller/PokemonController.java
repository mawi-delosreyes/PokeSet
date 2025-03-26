package com.pokeset.controller;

import com.pokeset.dto.PokemonPreset;
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

    @PostMapping("register")
    public ResponseEntity postRegisterPokemonPreset(
            @RequestBody PokemonPreset pokemon_preset
    ){
        Response response = pokemonPresetService.postRegisterPokemonPreset(pokemon_preset);

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
