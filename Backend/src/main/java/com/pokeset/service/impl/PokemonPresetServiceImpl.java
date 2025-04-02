package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.*;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonPresetDataRepository;
import com.pokeset.repository.PokemonPresetRepository;
import com.pokeset.service.PokemonPresetService;
import com.pokeset.util.ResponseUtil;
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
        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetData pokemonPresetData = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();

        if (pokemonPreset.getPresetId() != null){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_EXISTING);
        }

        try{
            pokemonPresetRepository.save(pokemonPreset);
            pokemonEvRepository.save(pokemonEv);
            pokemonPresetData.setPresetId(pokemonPreset.getPresetId());
            pokemonPresetData.setPokemonId(pokemonPreset.getPokemonId());
            pokemonPresetData.setEvId(pokemonEv.getEvId());
            pokemonPresetDataRepository.save(pokemonPresetData);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_REGISTERED);
    }

    public Response<Object> postEditPokemonPreset(PokemonPresetRequestWrapper pokemonPresetRequestWrapper){
        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetData pokemonPresetData = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();


        Optional<PokemonPreset> existingPreset = pokemonPresetRepository.findByPresetId(pokemonPreset.getPresetId());
        if(existingPreset.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_NOT_FOUND);
        }

        Optional<PokemonPresetData> existingPresetData = pokemonPresetDataRepository.findByPresetId(existingPreset.get().getPresetId());
        if(existingPresetData.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_DATA_NOT_FOUND);
        }

        Optional<PokemonEv> existingEv = pokemonEvRepository.findByEvId(existingPresetData.get().getEvId());
        if(existingEv.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.EV_NOT_FOUND);
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
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_UPDATED);
    }

    public Response<Object> getPokemonPreset(Integer presetId){
        Optional<PokemonPreset> preset = pokemonPresetRepository.findByPresetId(presetId);
        if(preset.isEmpty()) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_NOT_FOUND);
        }

        Optional<PokemonPresetData> preset_data = pokemonPresetDataRepository.findByPresetDataId(preset.get().getPresetId());
        if(preset_data.isEmpty()) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_DATA_NOT_FOUND);
        }

        Optional<PokemonEv> preset_ev = pokemonEvRepository.findByEvId(preset_data.get().getEvId());
        if(preset_ev.isEmpty()) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.EV_NOT_FOUND);
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

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_FOUND, individualPresetModel);
    }

    public Response<Object> getAllPokemonPreset(Integer userId, Integer pokemonId){
        Optional<List<PokemonPreset>> all_preset_list = pokemonPresetRepository.findAllByUserIdAndPokemonId(userId, pokemonId);
        if(all_preset_list.isEmpty()){
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_NOT_FOUND);
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
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_FOUND, presetListModel);
    }
}
