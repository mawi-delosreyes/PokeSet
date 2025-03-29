package com.pokeset.repository;

import com.pokeset.dto.MatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchDetails, Integer> {
}
