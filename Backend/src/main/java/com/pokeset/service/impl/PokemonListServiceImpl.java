package com.pokeset.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pokeset.constants.ResponseConstants;
import com.pokeset.dto.PokemonList;
import com.pokeset.model.BaseResponse;
import com.pokeset.model.PokemonListModel;
import com.pokeset.repository.PokemonListRepository;
import com.pokeset.service.PokemonListService;
import com.pokeset.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class PokemonListServiceImpl implements PokemonListService {

    @Autowired
    PokemonListRepository pokemonListRepository;

    public BaseResponse<Object> updatePokemonList(){
        Optional<PokemonList> pokemonList = pokemonListRepository.findTopByOrderByPokemonIdDesc();

        Boolean flag = Boolean.TRUE;
        Integer pokemon_id = pokemonList.get().getPokemonId() + 1;

        while(flag) {
            System.out.print(pokemon_id);
            String available_pokemon = updateFromURL(pokemon_id);

            if(available_pokemon.equals("Not Found")){
                flag = Boolean.FALSE;
            }

            pokemon_id += 1;
        }

        return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.POKEMON_LIST_UPDATED);
    }

    public BaseResponse<Object> getPokemonList(){
        Optional<List> pokemonList = Optional.of(pokemonListRepository.findAll());

        if(!pokemonList.isEmpty()) {
            return ResponseUtil.generatedResponse(ResponseConstants.SUCCESS, ResponseConstants.AVAILABLE_POKEMON_LIST, Collections.singletonList(pokemonList));
        } else {
            return ResponseUtil.generatedResponse(ResponseConstants.ERROR, ResponseConstants.UNAVAILABLE_POKEMON_LIST);
        }
    }

    private String updateFromURL(Integer id){

        PokemonList pokemonList = new PokemonList();

        try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String url = "https://pokeapi.co/api/v2/pokemon/" + id;
            String response = restTemplate.getForObject(url, String.class);
            Map<String, Object> pokemon_info = mapper.readValue(response, new TypeReference<>() {});

            List<Map<String, Object>> types = (List<Map<String, Object>>) pokemon_info.get("types");

            String type1 = (String) ((Map<String, Object>) types.get(0).get("type")).get("name");
            String type2 = null;

            if (types.size() > 1) {
                type2 = (String) ((Map<String, Object>) types.get(1).get("type")).get("name");
            }

            pokemonList.setPokemonId((Integer) pokemon_info.get("id"));
            pokemonList.setPokemonName((String) pokemon_info.get("name"));
            pokemonList.setType1(type1);
            pokemonList.setType2(type2);

            pokemonListRepository.save(pokemonList);
            return "Pokemon Added";
        } catch (Exception e) {
            System.out.print(e);
            return "Not Found";
        }
    }
}
