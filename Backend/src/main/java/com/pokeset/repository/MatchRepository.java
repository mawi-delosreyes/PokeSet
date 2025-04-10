package com.pokeset.repository;

import com.pokeset.dto.MatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<MatchDetails, Integer> {
    Optional<MatchDetails> findByTeamId(Integer teamId);
}
