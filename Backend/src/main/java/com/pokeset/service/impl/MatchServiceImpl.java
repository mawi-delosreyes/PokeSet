package com.pokeset.service.impl;

import com.pokeset.dto.MatchDetails;
import com.pokeset.model.MatchRequestWrapper;
import com.pokeset.repository.MatchRepository;
import com.pokeset.model.Response;
import com.pokeset.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    public Response<Object> postRegisterMatch(MatchRequestWrapper matchRequestWrapper){
        Response response = new Response();
        MatchDetails matchDetails = new MatchDetails();

        matchDetails.setMatchDate(matchRequestWrapper.getMatchDate());
        matchDetails.setUserId(matchRequestWrapper.getUserId());
        matchDetails.setTeamId(matchRequestWrapper.getTeamId());
        matchDetails.setNumberOfGames(matchRequestWrapper.getNumGames());
        matchDetails.setPokemonOppponent1(matchRequestWrapper.getOpponentTeam().get("pokemon1"));
        matchDetails.setPokemonOppponent2(matchRequestWrapper.getOpponentTeam().get("pokemon2"));
        matchDetails.setPokemonOppponent3(matchRequestWrapper.getOpponentTeam().get("pokemon3"));
        matchDetails.setPokemonOppponent4(matchRequestWrapper.getOpponentTeam().get("pokemon4"));
        matchDetails.setPokemonOppponent5(matchRequestWrapper.getOpponentTeam().get("pokemon5"));
        matchDetails.setPokemonOppponent6(matchRequestWrapper.getOpponentTeam().get("pokemon6"));
        matchDetails.setResult(matchRequestWrapper.getResult());

        try{
            matchRepository.save(matchDetails);
            response.setStatus("success");
            response.setMessage("Match has been saved");
        } catch(Exception e){
            response.setStatus("error");
            response.setMessage(e.toString());
        }
        return response;
    }
}
