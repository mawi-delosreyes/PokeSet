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

    @Column(name = "opponent_1")
    private Integer opponent_1;

    @Column(name = "opponent_2")
    private Integer opponent_2;

    @Column(name = "opponent_3")
    private Integer opponent_3;

    @Column(name = "opponent_4")
    private Integer opponent_4;

    @Column(name = "opponent_5")
    private Integer opponent_5;

    @Column(name = "opponent_6")
    private Integer opponent_6;

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

    public Integer getPokemonOpponent1() {
        return opponent_1;
    }

    public void setPokemonOppponent1(Integer opponent_1) {
        this.opponent_1 = opponent_1;
    }

    public Integer getPokemonOpponent2() {
        return opponent_2;
    }

    public void setPokemonOppponent2(Integer opponent_2) {
        this.opponent_2 = opponent_2;
    }

    public Integer getPokemonOpponent3() {
        return opponent_3;
    }

    public void setPokemonOppponent3(Integer opponent_3) {
        this.opponent_3 = opponent_3;
    }

    public Integer getPokemonOpponent4() {
        return opponent_4;
    }

    public void setPokemonOppponent4(Integer opponent_4) {
        this.opponent_4 = opponent_4;
    }

    public Integer getPokemonOpponent5() {
        return opponent_5;
    }

    public void setPokemonOppponent5(Integer opponent_5) {
        this.opponent_5 = opponent_5;
    }

    public Integer getPokemonOpponent6() {
        return opponent_6;
    }

    public void setPokemonOppponent6(Integer opponent_6) {
        this.opponent_6 = opponent_6;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
