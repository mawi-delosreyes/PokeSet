package com.pokeset.repository;

import com.pokeset.dto.PokemonMoves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonMoveRepository extends JpaRepository<PokemonMoves, PokemonMoves> {
    Optional<PokemonMoves> findByMoveName(String moveName);
}
