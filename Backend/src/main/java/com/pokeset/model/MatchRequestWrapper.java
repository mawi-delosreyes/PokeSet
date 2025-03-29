package com.pokeset.model;

import java.util.Date;
import java.util.Map;

public class MatchRequestWrapper {
    private Date matchDate;
    private Integer userId;
    private Integer teamId;
    private Integer numGames;
    private Map<String, Integer> opponentTeam;
    private String result;

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getNumGames() {
        return numGames;
    }

    public void setNumGames(Integer numGames) {
        this.numGames = numGames;
    }

    public Map<String, Integer> getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(Map<String, Integer> opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
