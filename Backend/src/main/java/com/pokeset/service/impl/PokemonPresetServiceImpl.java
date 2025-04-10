package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonEv;
import com.pokeset.dto.PokemonMoves;
import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.*;
import com.pokeset.repository.PokemonEvRepository;
import com.pokeset.repository.PokemonMoveRepository;
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

    @Autowired
    private PokemonMoveRepository pokemonMoveRepository;

    public BaseResponse<Object> postRegisterPokemonPreset(PokemonPresetRequestWrapper pokemonPresetRequestWrapper){
        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetDataModel pokemonPresetDataModel = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();

        try{
            if (pokemonPreset.getPresetId() != null){
                return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_EXISTING);
            }

            Integer move1_id = null;
            Integer move2_id = null;
            Integer move3_id = null;
            Integer move4_id = null;

            try {
                move1_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove1());
                move2_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove2());
                move3_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove3());
                move4_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove4());
            } catch(Exception e) {
                return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
            }

            pokemonPresetRepository.save(pokemonPreset);
            pokemonEvRepository.save(pokemonEv);

            PokemonPresetData pokemonPresetData = setPokemonPresetData(pokemonPreset, pokemonEv, move1_id, move2_id, move3_id, move4_id, pokemonPresetDataModel);
            pokemonPresetDataRepository.save(pokemonPresetData);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_REGISTERED);
    }

    public BaseResponse<Object> postEditPokemonPreset(PokemonPresetRequestWrapper pokemonPresetRequestWrapper){
        PokemonPreset pokemonPreset = pokemonPresetRequestWrapper.getPokemonPreset();
        PokemonPresetDataModel pokemonPresetDataModel = pokemonPresetRequestWrapper.getPokemonPresetData();
        PokemonEv pokemonEv = pokemonPresetRequestWrapper.getPokemonEv();
        PokemonPresetData pokemonPresetData = new PokemonPresetData();


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

        Integer move1_id = null;
        Integer move2_id = null;
        Integer move3_id = null;
        Integer move4_id = null;

        try {
            move1_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove1());
            move2_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove2());
            move3_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove3());
            move4_id = checkIfMoveExist(pokemonPresetDataModel.getMoves().getMove4());
        } catch(Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        pokemonPreset.setPresetId(existingPreset.get().getPresetId());
        pokemonPresetData.setPresetDataId(existingPresetData.get().getPresetDataId());
        pokemonEv.setEvId(existingEv.get().getEvId());

        try{
            pokemonPresetRepository.save(pokemonPreset);
            pokemonEvRepository.save(pokemonEv);

            pokemonPresetData = setPokemonPresetData(pokemonPreset, pokemonEv, move1_id, move2_id, move3_id, move4_id, pokemonPresetDataModel);
            pokemonPresetDataRepository.save(pokemonPresetData);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_UPDATED);
    }

    public IndividualPresetResponse<Object> getPokemonPreset(Integer presetId){
        Optional<PokemonPreset> preset = pokemonPresetRepository.findByPresetId(presetId);
        if(preset.isEmpty()) {
            return (IndividualPresetResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_NOT_FOUND);
        }

        Optional<PokemonPresetData> preset_data = pokemonPresetDataRepository.findByPresetDataId(preset.get().getPresetId());
        if(preset_data.isEmpty()) {
            return (IndividualPresetResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.PRESET_DATA_NOT_FOUND);
        }

        Optional<PokemonEv> preset_ev = pokemonEvRepository.findByEvId(preset_data.get().getEvId());
        if(preset_ev.isEmpty()) {
            return (IndividualPresetResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.EV_NOT_FOUND);
        }


        IndividualPresetModel individualPresetModel = new IndividualPresetModel();

        individualPresetModel.setPresetId(preset.get().getPresetId());
        individualPresetModel.setPresetName(preset.get().getPresetName());
        individualPresetModel.setPokemonPresetData(setPokemonPresetData(preset_data.get()));
        individualPresetModel.setPokemonEv(setPokemonEv(preset_ev.get()));

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.PRESET_FOUND, individualPresetModel);
    }


    private PokemonPresetData setPokemonPresetData(PokemonPreset pokemonPreset, PokemonEv pokemonEv, Integer move1_id, Integer move2_id,
                                                   Integer move3_id, Integer move4_id, PokemonPresetDataModel pokemonPresetDataModel) {
        PokemonPresetData pokemonPresetData = new PokemonPresetData();

        pokemonPresetData.setPresetId(pokemonPreset.getPresetId());
        pokemonPresetData.setPokemonId(pokemonPreset.getPokemonId());
        pokemonPresetData.setEvId(pokemonEv.getEvId());
        pokemonPresetData.setMove1_id(move1_id);
        pokemonPresetData.setMove2_id(move2_id);
        pokemonPresetData.setMove3_id(move3_id);
        pokemonPresetData.setMove4_id(move4_id);
        pokemonPresetData.setItem(pokemonPresetDataModel.getItem());
        pokemonPresetData.setAbility(pokemonPresetDataModel.getAbility());
        pokemonPresetData.setNature(pokemonPresetDataModel.getNature());
        pokemonPresetData.setBattleMechanic(pokemonPresetDataModel.getBattleMechanic());
        pokemonPresetData.setType(pokemonPresetDataModel.getType());
        pokemonPresetData.setUsed(pokemonPresetDataModel.getUsed());

        return pokemonPresetData;
    }

    private PokemonPresetData setPokemonPresetData(PokemonPresetData presetData){
        PokemonPresetData pokemonPresetData = new PokemonPresetData();

        pokemonPresetData.setPresetDataId(presetData.getPresetDataId());
        pokemonPresetData.setPresetId(presetData.getPresetId());
        pokemonPresetData.setPokemonId(presetData.getPokemonId());
        pokemonPresetData.setMove1_id(presetData.getMove1_id());
        pokemonPresetData.setMove2_id(presetData.getMove2_id());
        pokemonPresetData.setMove3_id(presetData.getMove3_id());
        pokemonPresetData.setMove4_id(presetData.getMove4_id());
        pokemonPresetData.setItem(presetData.getItem());
        pokemonPresetData.setAbility(presetData.getAbility());
        pokemonPresetData.setNature(presetData.getNature());
        pokemonPresetData.setBattleMechanic(presetData.getBattleMechanic());
        pokemonPresetData.setType(presetData.getType());
        pokemonPresetData.setEvId(presetData.getEvId());
        pokemonPresetData.setUsed(presetData.isUsed());

        return pokemonPresetData;

    }

    private PokemonEv setPokemonEv(PokemonEv presetEv){
        PokemonEv pokemonEv = new PokemonEv();

        pokemonEv.setEvId(presetEv.getEvId());
        pokemonEv.setHp(presetEv.getHp());
        pokemonEv.setAttack(presetEv.getAttack());
        pokemonEv.setDefense(presetEv.getDefense());
        pokemonEv.setSpecialAttack(presetEv.getSpecialAttack());
        pokemonEv.setSpecialDefense(presetEv.getSpecialDefense());
        pokemonEv.setSpeed(presetEv.getSpeed());
        pokemonEv.setUsed(presetEv.isUsed());

        return pokemonEv;
    }

    private Integer checkIfMoveExist(PokemonMoves pokemonMoves){
        Optional<PokemonMoves> move = pokemonMoveRepository.findByMoveName(pokemonMoves.getMoveName());

        if(move == null) {
            pokemonMoveRepository.save(pokemonMoves);
        }
        return move.get().getMoveId();
    }
}

