package com.pokeset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "MatchDetails")
@Entity
public class MatchDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_detail_id")
    private Integer matchDetailId;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "match_date")
    private Date matchDate;

    @Column(name = "number_of_games")
    private Integer numberOfGames;

    @Column(name = "pokemon_preset_id_1")
    private Integer pokemonPresetId1;

    @Column(name = "pokemon_preset_id_2")
    private Integer pokemonPresetId2;

    @Column(name = "pokemon_preset_id_3")
    private Integer pokemonPresetId3;

    @Column(name = "pokemon_preset_id_4")
    private Integer pokemonPresetId4;

    @Column(name = "pokemon_preset_id_5")
    private Integer pokemonPresetId5;

    @Column(name = "pokemon_preset_id_6")
    private Integer pokemonPresetId6;

    @Column(name = "result")
    private String result;

    public Integer getMatchDetailId() {
        return matchDetailId;
    }

    public void setMatchDetailId(Integer matchDetailId) {
        this.matchDetailId = matchDetailId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public Integer getPokemonPresetId1() {
        return pokemonPresetId1;
    }

    public void setPokemonPresetId1(Integer pokemonPresetId1) {
        this.pokemonPresetId1 = pokemonPresetId1;
    }

    public Integer getPokemonPresetId2() {
        return pokemonPresetId2;
    }

    public void setPokemonPresetId2(Integer pokemonPresetId2) {
        this.pokemonPresetId2 = pokemonPresetId2;
    }

    public Integer getPokemonPresetId3() {
        return pokemonPresetId3;
    }

    public void setPokemonPresetId3(Integer pokemonPresetId3) {
        this.pokemonPresetId3 = pokemonPresetId3;
    }

    public Integer getPokemonPresetId4() {
        return pokemonPresetId4;
    }

    public void setPokemonPresetId4(Integer pokemonPresetId4) {
        this.pokemonPresetId4 = pokemonPresetId4;
    }

    public Integer getPokemonPresetId5() {
        return pokemonPresetId5;
    }

    public void setPokemonPresetId5(Integer pokemonPresetId5) {
        this.pokemonPresetId5 = pokemonPresetId5;
    }

    public Integer getPokemonPresetId6() {
        return pokemonPresetId6;
    }

    public void setPokemonPresetId6(Integer pokemonPresetId6) {
        this.pokemonPresetId6 = pokemonPresetId6;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
