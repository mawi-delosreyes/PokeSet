package com.pokeset.service.impl;

import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.*;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonPresetDataRepository;
import com.pokeset.repository.PokemonPresetRepository;
import com.pokeset.service.PokemonPresetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokemonPresetServiceImpl implements PokemonPresetService {

    private static final Logger log = LoggerFactory.getLogger(PokemonPresetServiceImpl.class);
    @Autowired
    private PokemonPresetRepository pokemonPresetRepository;

    @Autowired
    private PokemonPresetDataRepository pokemonPresetDataRepository;

    @Autowired
    private PokemonEvRepository pokemonEvRepository;

    public Response<Object> postRegisterPokemonPreset(PokemonPresetRequestWrapper pokemonPresetRequestWrapper){
        Response response = new Response();

        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetData pokemonPresetData = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();

        if (pokemonPreset.getPresetId() != null){
            response.setStatus("error");
            response.setMessage("Preset is already saved");
        }

        try{
            pokemonPresetRepository.save(pokemonPreset);
            pokemonEvRepository.save(pokemonEv);
            pokemonPresetData.setPresetId(pokemonPreset.getPresetId());
            pokemonPresetData.setPokemonId(pokemonPreset.getPokemonId());
            pokemonPresetData.setEvId(pokemonEv.getEvId());
            pokemonPresetDataRepository.save(pokemonPresetData);
        } catch (Exception e) {
            response.setStatus("error");
            response.setMessage(e.toString());
        }

        response.setStatus("success");
        response.setMessage("Pokemon Preset has been saved");

        return response;
    }

    public Response<Object> postEditPokemonPreset(PokemonPresetRequestWrapper pokemonPresetRequestWrapper){
        Response response = new Response();

        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetData pokemonPresetData = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();


        Optional<PokemonPreset> existingPreset = pokemonPresetRepository.findByPresetId(pokemonPreset.getPresetId());
        if(existingPreset.isEmpty()){
            response.setStatus("error");
            response.setMessage("Preset is not found");
            return response;
        }

        Optional<PokemonPresetData> existingPresetData = pokemonPresetDataRepository.findByPresetId(existingPreset.get().getPresetId());
        if(existingPresetData.isEmpty()){
            response.setStatus("error");
            response.setMessage("Preset Data is not found");
            return response;
        }

        Optional<PokemonEv> existingEv = pokemonEvRepository.findByEvId(existingPresetData.get().getEvId());
        if(existingEv.isEmpty()){
            response.setStatus("error");
            response.setMessage("Preset EV is not found");
            return response;
        }

        pokemonPreset.setPresetId(existingPreset.get().getPresetId());
        pokemonPresetData.setPresetDataId(existingPresetData.get().getPresetDataId());
        pokemonEv.setEvId(existingEv.get().getEvId());

        try{
            pokemonPresetRepository.save(pokemonPreset);
            pokemonEvRepository.save(pokemonEv);
            pokemonPresetData.setPresetId(pokemonPreset.getPresetId());
            pokemonPresetData.setPokemonId(pokemonPreset.getPokemonId());
            pokemonPresetData.setEvId(pokemonEv.getEvId());
            pokemonPresetDataRepository.save(pokemonPresetData);
        } catch (Exception e) {
            response.setStatus("error");
            response.setMessage(e.toString());
        }

        response.setStatus("success");
        response.setMessage("Pokemon Preset has been updated");

        return response;
    }

    public Response<Object> getPokemonPreset(Integer presetId){
        Response response = new Response();

        Optional<PokemonPreset> preset = pokemonPresetRepository.findByPresetId(presetId);
        if(preset.isEmpty()) {
            response.setStatus("error");
            response.setMessage("No Pokemon Preset found");
            return response;
        }

        Optional<PokemonPresetData> preset_data = pokemonPresetDataRepository.findByPresetDataId(preset.get().getPresetId());
        if(preset_data.isEmpty()) {
            response.setStatus("error");
            response.setMessage("No Pokemon Preset Data found");
            return response;
        }

        Optional<PokemonEv> preset_ev = pokemonEvRepository.findByEvId(preset_data.get().getEvId());
        if(preset_ev.isEmpty()) {
            response.setStatus("error");
            response.setMessage("No Pokemon EV Data found");
            return response;
        }

        PokemonPresetData pokemonPresetData = new PokemonPresetData();
        PokemonEv pokemonEv = new PokemonEv();
        IndividualPresetModel individualPresetModel = new IndividualPresetModel();

        pokemonPresetData.setPresetDataId(preset_data.get().getPresetDataId());
        pokemonPresetData.setPresetId(preset_data.get().getPresetId());
        pokemonPresetData.setPokemonId(preset_data.get().getPokemonId());
        pokemonPresetData.setMove1(preset_data.get().getMove1());
        pokemonPresetData.setMove2(preset_data.get().getMove2());
        pokemonPresetData.setMove3(preset_data.get().getMove3());
        pokemonPresetData.setMove4(preset_data.get().getMove4());
        pokemonPresetData.setItem(preset_data.get().getItem());
        pokemonPresetData.setAbility(preset_data.get().getAbility());
        pokemonPresetData.setNature(preset_data.get().getNature());
        pokemonPresetData.setBattleMechanic(preset_data.get().getBattleMechanic());
        pokemonPresetData.setType(preset_data.get().getType());
        pokemonPresetData.setEvId(preset_data.get().getEvId());
        pokemonPresetData.setUsed(preset_data.get().isUsed());

        pokemonEv.setEvId(preset_ev.get().getEvId());
        pokemonEv.setHp(preset_ev.get().getHp());
        pokemonEv.setAttack(preset_ev.get().getAttack());
        pokemonEv.setDefense(preset_ev.get().getDefense());
        pokemonEv.setSpecialAttack(preset_ev.get().getSpecialAttack());
        pokemonEv.setSpecialDefense(preset_ev.get().getSpecialDefense());
        pokemonEv.setSpeed(preset_ev.get().getSpeed());
        pokemonEv.setUsed(preset_ev.get().isUsed());

        individualPresetModel.setPresetId(preset.get().getPresetId());
        individualPresetModel.setPresetName(preset.get().getPresetName());
        individualPresetModel.setPokemonPresetData(pokemonPresetData);
        individualPresetModel.setPokemonEv(pokemonEv);

        response.setStatus("success");
        response.setMessage("Pokemon Preset found");
        response.setData(individualPresetModel);
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
        PresetListModel presetListModel = new PresetListModel();
        PresetModel presetModel;
        presetListModel.setPokemonId(pokemonId);
        presetListModel.setUserId(userId);

        for(PokemonPreset preset : all_preset_list.get()){
            presetModel = new PresetModel();
            presetModel.setPresetId(preset.getPresetId());
            presetModel.setPresetName(preset.getPresetName());
            presetModel.setTeamId(preset.getTeamId());

            preset_list.add(presetModel);
        }

        presetListModel.setPresetList(preset_list);


        response = new Response<PresetListModel>(
                "success",
                "Presets found",
                presetListModel
        );

        return response;
    }
}
