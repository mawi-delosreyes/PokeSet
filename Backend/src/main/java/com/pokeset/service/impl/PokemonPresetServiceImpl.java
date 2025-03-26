package com.pokeset.service.impl;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.Response;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonPresetDataRepository;
import com.pokeset.repository.PokemonPresetRepository;
import com.pokeset.service.PokemonPresetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PokemonPresetServiceImpl implements PokemonPresetService {

    @Autowired
    private PokemonPresetRepository pokemonPresetRepository;

    @Autowired
    private PokemonPresetDataRepository pokemonPresetDataRepository;

    @Autowired
    private PokemonEvRepository pokemonEvRepository;

    public Response<Object> postRegisterPokemonPreset(PokemonPreset pokemonPreset){
        Response response;
        try{
            pokemonPresetRepository.save(pokemonPreset);
            response = new Response<Map>(
                    "success",
                    "Pokemon Preset has been saved"
            );
        } catch (Exception e){
            response = new Response<Map>(
                    "error",
                    e.toString()
            );
        }
        return response;
    }

    public Response<Object> getPokemonPreset(Integer presetId){
        Response response;

        Optional<PokemonPreset> preset = pokemonPresetRepository.findByPresetId(presetId);
        if(preset.isEmpty()) {
            response = new Response<Map>(
                    "error",
                    "No Pokemon Preset found"
            );
            return response;
        }

        Optional<PokemonPresetData> preset_data = pokemonPresetDataRepository.findByPresetDataId(preset.get().getPresetId());
        if(preset_data.isEmpty()) {
            response = new Response<Map>(
                    "error",
                    "No Pokemon Preset found"
            );
            return response;
        }

        Map<String, String> preset_moves = new HashMap<>();
        preset_moves.put("move1", preset_data.get().getMove1());
        preset_moves.put("move2", preset_data.get().getMove2());
        preset_moves.put("move3", preset_data.get().getMove3());
        preset_moves.put("move4", preset_data.get().getMove4());

        Optional<PokemonEv> preset_ev = pokemonEvRepository.findByEvId(preset_data.get().getEvId());
        if(preset_ev.isEmpty()) {
            response = new Response<Map>(
                    "error",
                    "No Pokemon EV Data found"
            );
            return response;
        }

        Map<String, Object> preset_evs = new HashMap<>();
        preset_evs.put("hp", preset_ev.get().getHp());
        preset_evs.put("attack", preset_ev.get().getAttack());
        preset_evs.put("defense", preset_ev.get().getDefense());
        preset_evs.put("special_attack", preset_ev.get().getSpecialAttack());
        preset_evs.put("special_defense", preset_ev.get().getSpecialDefense());
        preset_evs.put("speed", preset_ev.get().getSpeed());

        Map<String, Object> pokemon_preset = new HashMap<>();
        pokemon_preset.put("preset_id", preset.get().getPresetId());
        pokemon_preset.put("preset_name", preset.get().getPresetName());
        pokemon_preset.put("moves", preset_moves);
        pokemon_preset.put("item", preset_data.get().getItem());
        pokemon_preset.put("ability", preset_data.get().getAbility());
        pokemon_preset.put("nature", preset_data.get().getNature());
        pokemon_preset.put("battle_mechanic", preset_data.get().getBattleMechanic());
        pokemon_preset.put("battle_mechanic_type", preset_data.get().getType());
        pokemon_preset.put("ev", preset_evs);

        response = new Response<Map>(
                "success",
                "Pokemon Preset found",
                pokemon_preset
        );

        return response;
    }

    public Response<Object> getAllPokemonPreset(Integer userId, Integer pokemonId){
        Response response;

        Optional<List<PokemonPreset>> all_preset_list = pokemonPresetRepository.findAllByUserIdAndPokemonId(userId, pokemonId);
        if(all_preset_list.isEmpty()){
            response = new Response<Map>(
                    "error",
                    "No Presets found"
            );
            return response;
        }

        HashMap<String, Object> preset_list = new HashMap<>();
        preset_list.put("pokemon_id", pokemonId);
        preset_list.put("user_id", userId);

        for(PokemonPreset preset : all_preset_list.get()){
            HashMap<String, Object> individual_preset_info = new HashMap<>();
            individual_preset_info.put("preset_id", preset.getPresetId());
            individual_preset_info.put("preset_name", preset.getPresetName());
            individual_preset_info.put("team_id", preset.getTeamId());

            preset_list.put("preset_"+preset.getPresetId(), individual_preset_info);
        }

        response = new Response<Map>(
                "success",
                "Presets found",
                preset_list
        );

        return response;
    }
}
