package com.pokeset.repository;

import com.pokeset.dto.PokemonList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonListRepository extends JpaRepository<PokemonList, PokemonList> {
    Optional<PokemonList> findTopByOrderByPokemonIdDesc();
}
