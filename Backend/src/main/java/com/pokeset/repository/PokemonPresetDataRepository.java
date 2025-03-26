package com.pokeset.repository;

import com.pokeset.dto.PokemonPresetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonPresetDataRepository extends JpaRepository<PokemonPresetData, Integer> {
    Optional<PokemonPresetData> findByPresetDataId(Integer presetDataId);
}
