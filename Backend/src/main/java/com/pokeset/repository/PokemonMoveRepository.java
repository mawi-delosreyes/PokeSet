package com.pokeset.repository;

import com.pokeset.dto.PokemonMoves;
import com.pokeset.model.PokemonMoveModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonMoveRepository extends JpaRepository<PokemonMoves, Integer> {
    Optional<PokemonMoves> findByMoveName(String moveId);
}
