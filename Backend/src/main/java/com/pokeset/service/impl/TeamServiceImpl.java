package com.pokeset.service.impl;

import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.*;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.PokemonPresetModel;
import com.pokeset.model.PokemonTeamPresetsModel;
import com.pokeset.model.TeamResponse;
import com.pokeset.repository.*;
import com.pokeset.service.TeamService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PokemonPresetRepository pokemonPresetRepository;

    @Autowired
    private PokemonPresetDataRepository pokemonPresetDataRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PokemonEvRepository pokemonEvRepository;

    public BaseResponse<Object> postRegisterTeam(Team team){
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_REGISTERED);
    }

    public BaseResponse<Object> postEditTeam(Team team) {
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, e.toString());
        }
        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_UPDATED);
    }

    public TeamResponse<Object> getTeam(Integer teamId, Integer userId, Boolean access) {
        PokemonTeamPresetsModel pokemonTeamPresetsModel = new PokemonTeamPresetsModel();

        Optional<Team> team_info = teamRepository.findTeamNameByTeamIdAndUserIdAndAccess(teamId, userId, access);
        if(team_info.isEmpty()) {
           return (TeamResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.TEAM_NOT_FOUND);
        }

        String teamName = team_info.get().getTeamName();
        Optional<List<PokemonPreset>> pokemon_presets = pokemonPresetRepository.findByTeamIdAndUserIdOrderByTeamArrange(teamId, userId);

        Integer num_preset = pokemon_presets.get().size();
        if (num_preset >= 1) {
            pokemonTeamPresetsModel.setPokemonPresetModel1(checkPresetExist(pokemon_presets.get().get(0)));
        }
        if (num_preset >= 2) {
            pokemonTeamPresetsModel.setPokemonPresetModel2(checkPresetExist(pokemon_presets.get().get(1)));
        }
        if (num_preset >= 3) {
            pokemonTeamPresetsModel.setPokemonPresetModel3(checkPresetExist(pokemon_presets.get().get(2)));
        }
        if (num_preset >= 4) {
            pokemonTeamPresetsModel.setPokemonPresetModel4(checkPresetExist(pokemon_presets.get().get(3)));
        }
        if (num_preset >= 5) {
            pokemonTeamPresetsModel.setPokemonPresetModel5(checkPresetExist(pokemon_presets.get().get(4)));
        }
        if (num_preset >= 6) {
            pokemonTeamPresetsModel.setPokemonPresetModel6(checkPresetExist(pokemon_presets.get().get(5)));
        }

        Optional<MatchDetails> matchDetails = matchRepository.findByTeamId(team_info.get().getTeamId());


        return (TeamResponse<Object>) ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.TEAM_FOUND,
                teamName, teamId, userId, pokemonTeamPresetsModel, matchDetails.get());


    }

    private PokemonPresetModel checkPresetExist(PokemonPreset pokemonPreset) {
        PokemonPresetModel pokemonPresetModel = new PokemonPresetModel();

        Optional<PokemonPresetData> pokemon_preset_data = pokemonPresetDataRepository.findByPresetId(pokemonPreset.getPresetId());
        Optional<PokemonEv> pokemon_ev = pokemonEvRepository.findByEvId(pokemon_preset_data.get().getEvId());

        pokemonPresetModel.setPresetId(pokemonPreset.getPresetId());
        pokemonPresetModel.setPokemonId(pokemonPreset.getPokemonId());
        pokemonPresetModel.setPokemonName(null);
        pokemonPresetModel.setPokemonType1(null);
        pokemonPresetModel.setPokemonType2(null);
        pokemonPresetModel.setNature(pokemon_preset_data.get().getNature());
        pokemonPresetModel.setItem(pokemon_preset_data.get().getItem());
        pokemonPresetModel.setAbility(pokemon_preset_data.get().getAbility());
        pokemonPresetModel.setBattleMechanic(pokemon_preset_data.get().getBattleMechanic());
        pokemonPresetModel.setType(pokemon_preset_data.get().getType());
        pokemonPresetModel.setPokemonMovesModel(pokemonPresetModel.getPokemonMovesModel());
        pokemonPresetModel.setPokemonEv(pokemon_ev.get());

        return pokemonPresetModel;
    }
}
