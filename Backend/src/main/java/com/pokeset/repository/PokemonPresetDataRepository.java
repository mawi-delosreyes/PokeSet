package com.pokeset.repository;

import com.pokeset.dto.PokemonPresetData;
import com.pokeset.model.PokemonPresetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonPresetDataRepository extends JpaRepository<PokemonPresetData, Integer> {
    Optional<PokemonPresetData> findByPresetDataId(Integer presetDataId);
    Optional<PokemonPresetData> findByPresetId(Integer presetId);

    @Query(nativeQuery = true,
            value = """
       SELECT pp.preset_id, pp.pokemon_id, pl.pokemon_name, pl.type_1, pl.type_2, pd.nature,
              pd.item, pd.ability, pd.battle_mechanic, pd.type
       FROM PokemonPreset pp
       JOIN PokemonList pl ON pp.pokemon_id  = pl.pokemon_id
       JOIN PokemonPresetData pd ON pp.preset_id = pd.preset_id AND pp.pokemon_id = pd.pokemon_id
       WHERE pp.preset_id = :presetId
       ORDER BY pp.preset_id
       """)
    List<Object[]> findPresetsWithPokemonDetails(Integer presetId);
}
