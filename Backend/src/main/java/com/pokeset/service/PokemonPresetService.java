package com.pokeset.service;

import com.pokeset.model.IndividualPresetResponse;
import com.pokeset.model.PokemonPresetRequestWrapper;
import com.pokeset.model.BaseResponse;

public interface PokemonPresetService {
    BaseResponse<Object> postRegisterPokemonPreset(PokemonPresetRequestWrapper PokemonPresetRequestWrapper);
    BaseResponse<Object> postEditPokemonPreset(PokemonPresetRequestWrapper PokemonPresetRequestWrapper);
    IndividualPresetResponse<Object> getPokemonPreset(Integer presetId);
}
