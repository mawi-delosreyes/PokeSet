package com.pokeset.repository;

import com.pokeset.dto.PokemonPreset;
import com.pokeset.dto.PokemonPresetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonPresetRepository extends JpaRepository<PokemonPreset, Integer> {
    Optional<PokemonPreset> findByPresetId(Integer presetId);
    Optional<List<PokemonPreset>> findAllByUserIdAndPokemonId(Integer userId, Integer pokemonId);
    Optional<PokemonPreset> findByTeamId(Integer teamId);

}
