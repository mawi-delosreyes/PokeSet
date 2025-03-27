package com.pokeset.service.impl;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.IndividualPresetModel;
import com.pokeset.model.PresetList;
import com.pokeset.model.PresetModel;
import com.pokeset.model.Response;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonPresetDataRepository;
import com.pokeset.repository.PokemonPresetRepository;
import com.pokeset.service.PokemonPresetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.*;

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

        Optional<PokemonEv> preset_ev = pokemonEvRepository.findByEvId(preset_data.get().getEvId());
        if(preset_ev.isEmpty()) {
            response = new Response<Map>(
                    "error",
                    "No Pokemon EV Data found"
            );
            return response;
        }

        IndividualPresetModel individualPresetModel = new IndividualPresetModel();

        individualPresetModel.setMove1(preset_data.get().getMove1());
        individualPresetModel.setMove2(preset_data.get().getMove2());
        individualPresetModel.setMove3(preset_data.get().getMove3());
        individualPresetModel.setMove4(preset_data.get().getMove4());
        individualPresetModel.setItem(preset_data.get().getItem());
        individualPresetModel.setAbility(preset_data.get().getAbility());
        individualPresetModel.setNature(preset_data.get().getNature());
        individualPresetModel.setBattleMechanic(preset_data.get().getBattleMechanic());
        individualPresetModel.setBattleMechanicType(preset_data.get().getType());

        individualPresetModel.setHp(preset_ev.get().getHp());
        individualPresetModel.setAttack(preset_ev.get().getAttack());
        individualPresetModel.setDefense(preset_ev.get().getDefense());
        individualPresetModel.setSpecialAttack(preset_ev.get().getSpecialAttack());
        individualPresetModel.setSpecialDefense(preset_ev.get().getSpecialDefense());
        individualPresetModel.setSpeed(preset_ev.get().getSpeed());

        individualPresetModel.setPresetId(preset.get().getPresetId());
        individualPresetModel.setPresetName(preset.get().getPresetName());

        response = new Response<IndividualPresetModel>(
                "success",
                "Pokemon Preset found",
                individualPresetModel
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

        ArrayList preset_list = new ArrayList<>();
        PresetList presetList = new PresetList();
        PresetModel presetModel;
        presetList.setPokemonId(pokemonId);
        presetList.setUserId(userId);

        for(PokemonPreset preset : all_preset_list.get()){
            presetModel = new PresetModel();
            presetModel.setPresetId(preset.getPresetId());
            presetModel.setPresetName(preset.getPresetName());
            presetModel.setTeamId(preset.getTeamId());

            preset_list.add(presetModel);
        }

        presetList.setPresetList(preset_list);


        response = new Response<PresetList>(
                "success",
                "Presets found",
                presetList
        );

        return response;
    }
}
