package com.pokeset.repository;

import com.pokeset.dto.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findTeamNameByTeamIdAndUserIdAndAccess(Integer teamId, Integer userId, Boolean isAccess);
    Optional<List> findAllByUserIdAndAccess(Integer userId, Boolean Access);
}
