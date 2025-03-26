package com.pokeset.repository;

import com.pokeset.dto.PokemonEv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonEvRepository extends JpaRepository<PokemonEv, Integer> {
    Optional<PokemonEv> findByEvId(Integer evId);
}
