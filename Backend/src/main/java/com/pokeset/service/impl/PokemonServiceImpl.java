package com.pokeset.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeset.constants.ResponseConstants;
import com.pokeset.model.PokemonInfo;
import com.pokeset.model.PokemonInfoResponse;
import com.pokeset.service.PokemonService;
import com.pokeset.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class PokemonServiceImpl implements PokemonService {
    public PokemonInfoResponse<PokemonInfo> getPokemonInfo(Integer pokemonId) {
        PokemonInfo pokemonInfo = new PokemonInfo();

        try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String pokemonUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonId;
            String pokemonResponse = restTemplate.getForObject(pokemonUrl, String.class);
            Map<String, Object> pokemon = mapper.readValue(pokemonResponse, new TypeReference<>() {});

            String pokemonSpeciesUrl = "https://pokeapi.co/api/v2/pokemon-species/" + pokemonId;
            String speciesResponse = restTemplate.getForObject(pokemonSpeciesUrl, String.class);
            Map<String, Object> pokemonSpecies = mapper.readValue(speciesResponse, new TypeReference<>() {});

            pokemonInfo.setSpriteUrl(getSpriteUrl(pokemon));
            pokemonInfo.setDescription(getPokemonDescription(pokemonSpecies));
            List<String> pokemonTypes = getPokemonTypes(pokemon);
            pokemonInfo.setType1(pokemonTypes.get(0).toString());
            if (pokemonTypes.get(1) != null) {
                pokemonInfo.setType2(pokemonTypes.get(1).toString());
            } else {
                pokemonInfo.setType2(null);
            }
            pokemonInfo.setAbilities(getAbility(pokemon));
            pokemonInfo.setWeaknesses(getWeakness(pokemon));
            pokemonInfo.setEvolution(getEvolution(pokemonSpecies));
            pokemonInfo.setMoveList(moveList(pokemon));

            return ResponseUtil.generatePokemonResponse(ResponseConstants.SUCCESS, ResponseConstants.POKEMON_INFO_SUCCESS, pokemonInfo);
        } catch (Exception e) {
            return ResponseUtil.generatePokemonResponse(ResponseConstants.ERROR, e.toString());
        }
    }

    private String getSpriteUrl(Map<String, Object> pokemon) {
        Map<String, String> spriteList = (Map<String, String>) pokemon.get("sprites");
        return spriteList.get("front_default");
    }

    private String getPokemonDescription(Map<String, Object> pokemonSpecies) {
        List<Map<String, Object>> flavorEntries = (List<Map<String, Object>>) pokemonSpecies.get("flavor_text_entries");
        return flavorEntries.get(0).get("flavor_text").toString().replace("\n", " ").replace("\f", " ");
    }

    private List getPokemonTypes(Map<String, Object> pokemon) {
        List types = new ArrayList<>();
        List<Map<String, Object>> type = (List<Map<String, Object>>) pokemon.get("types");

        Map<String, Object> type1 = (Map<String, Object>) type.get(0).get("type");
        types.add(type1.get("name").toString());

        if (type.size() > 1) {
            Map<String, Object> type2 = (Map<String, Object>) type.get(1).get("type");
            types.add(type2.get("name").toString());
        } else {
            types.add(null);
        }
        return types;
    }

    private List<Map<String, String>> getAbility(Map<String, Object> pokemon) {
        List<Map<String, String>> pokemonAbilities = new ArrayList<>();
        List<Map<String, Object>> abilitiesList = (List<Map<String, Object>>) pokemon.get("abilities");

        if (abilitiesList != null) {
            for (Map<String, Object> abilityEntry : abilitiesList) {
                Map<String, Object> abilityMap = (Map<String, Object>) abilityEntry.get("ability");
                String abilityName = (String) abilityMap.get("name");
                String abilityDescription = getAbilityDescription(abilityMap.get("url").toString());

                Map<String, String> abilityObj = new HashMap<>();
                abilityObj.put(abilityName, abilityDescription);
                pokemonAbilities.add(abilityObj);
            }
        }
        return pokemonAbilities;
    }

    private String getAbilityDescription(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String abilityResponse = restTemplate.getForObject(url, String.class);
            Map<String, Object> ability = mapper.readValue(abilityResponse, new TypeReference<>() {});
            List<Map<String, Object>> effects = (List<Map<String, Object>>) ability.get("effect_entries");

            String language = null;
            Integer ctr = 0;
            while (!"en".equals(language)) {
                Map<String, Object> effectEntry = effects.get(ctr);
                Map<String, String> effectLanguage = (Map<String, String>) effectEntry.get("language");
                language = effectLanguage.get("name");
                ctr += 1;
            }
            return effects.get(ctr-1).get("effect").toString().replace("\n", " ").replace("\f", " ");
        } catch (Exception e) {
            return e.toString();
        }
    }

    private List getWeakness(Map<String, Object> pokemon) {
        List<Map<String, Object>> types = (List<Map<String, Object>>) pokemon.get("types");
        List supperEffectiveList = new ArrayList();
        try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String typeResponse;
            List pokemonType = new ArrayList<>();


            Map<String, String> type1 = (Map<String, String>) types.get(0).get("type");
            pokemonType.add(type1.get("name"));

            if (types.size() > 1) {
                Map<String, String> type2 = (Map<String, String>) types.get(1).get("type");
                pokemonType.add(type2.get("name"));

                typeResponse = restTemplate.getForObject(type2.get("url"), String.class);
                Map<String, Object> type2Data = mapper.readValue(typeResponse, new TypeReference<>() {});
                supperEffectiveList = weakness(type2Data, supperEffectiveList, pokemonType);
            }

            typeResponse = restTemplate.getForObject(type1.get("url"), String.class);
            Map<String, Object> type1Data = mapper.readValue(typeResponse, new TypeReference<>() {});
            supperEffectiveList = weakness(type1Data, supperEffectiveList, pokemonType);
            return supperEffectiveList;

        } catch (Exception e) {
            return Collections.singletonList((e.toString()));
        }
    }

    private List weakness(Map<String, Object> typeData, List supperEffectiveList, List pokemonType) {
        Map<String, Object> damageRelations = (Map<String, Object>) typeData.get("damage_relations");
        List<Map<String, Object>> doubleDamage = (List<Map<String, Object>>) damageRelations.get("double_damage_from");

        for (Map<String, Object> type : doubleDamage) {
            String typeName = type.get("name").toString();
            if (!supperEffectiveList.contains(typeName) && !pokemonType.contains(typeName)) {
                supperEffectiveList.add(typeName);
            }
        }return supperEffectiveList;
    }

    private Map<String, String> getEvolution(Map<String, Object> pokemonSpecies){
        try {
            Map<String, Object> evolution = (Map<String, Object>) pokemonSpecies.get("evolution_chain");
            String evolutionChainUrl = evolution.get("url").toString();

            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String evolutionResponse = restTemplate.getForObject(evolutionChainUrl, String.class);
            Map<String, Object> evolveResponse = mapper.readValue(evolutionResponse, new TypeReference<>() {});
            Map<String, Object> evolutionChainMap = (Map<String, Object>) evolveResponse.get("chain");
            Map<String, String> evolutionChain = extractEvolutionChain(evolutionChainMap);
            return evolutionChain;

        } catch (Exception e) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.toString());
            return errorMap;
        }
    }

    private Map<String, String> extractEvolutionChain(Map<String, Object> chain) {
        Map<String, String> speciesMap = new LinkedHashMap<>();
        collectSpecies(chain, speciesMap);
        return speciesMap;
    }

    private void collectSpecies(Map<String, Object> chainNode, Map<String, String> speciesMap) {
        if (chainNode == null) return;
        Map<String, Object> species = (Map<String, Object>) chainNode.get("species");
        if (species != null) {
            String name = (String) species.get("name");
            String speciesUrl = (String) species.get("url");

            try {
                String[] parts = speciesUrl.split("/");
                String pokemonId = parts[parts.length - 1].isEmpty() ? parts[parts.length - 2] : parts[parts.length - 1];

                RestTemplate restTemplate = new RestTemplate();
                ObjectMapper mapper = new ObjectMapper();
                String pokemonResponse = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + pokemonId, String.class);
                Map<String, Object> pokemonData = mapper.readValue(pokemonResponse, new TypeReference<>() {});
                Map<String, Object> sprites = (Map<String, Object>) pokemonData.get("sprites");
                String spriteUrl = (String) sprites.get("front_default");

                speciesMap.put(name, spriteUrl);
            } catch (Exception e) {
                speciesMap.put(name, "error:" + e.getMessage());
            }
        }

        List<Map<String, Object>> evolvesTo = (List<Map<String, Object>>) chainNode.get("evolves_to");
        if (evolvesTo != null) {
            for (Map<String, Object> nextChain : evolvesTo) {
                collectSpecies(nextChain, speciesMap);
            }
        }
    }

    private List<Map<String, String>> moveList(Map<String, Object> pokemon) {

        List<Map<String, Object>> moveList = (List<Map<String, Object>>) pokemon.get("moves");
        List<Map<String, String>> moves = new ArrayList<>();

        for (Map<String, Object> move : moveList) {
            Map<String, String> moveData = (Map<String, String>) move.get("move");
            Map<String, String> moveInfo = new HashMap<>();
            String moveName = moveData.get("name");
            String moveUrl = moveData.get("url");

            try {
                RestTemplate restTemplate = new RestTemplate();
                ObjectMapper mapper = new ObjectMapper();
                String moveUrlResponse = restTemplate.getForObject(moveUrl, String.class);
                Map<String, Object> moveResponse = mapper.readValue(moveUrlResponse, new TypeReference<>() {});

                List<Map<String, Object>> flavorTextEntries = (List<Map<String, Object>>) moveResponse.get("flavor_text_entries");

                String language = null;
                Integer ctr = 0;
                while (!"en".equals(language)) {
                    Map<String, Object> flavorTextEntry = flavorTextEntries.get(ctr);
                    Map<String, String> flavorTextLanguage = (Map<String, String>) flavorTextEntry.get("language");
                    language = flavorTextLanguage.get("name");
                    ctr += 1;
                }

                Map<String, Object> flavorText = flavorTextEntries.get(ctr-1);
                Map<String, Object> damageClass = (Map<String, Object>) moveResponse.get("damage_class");
                String moveDescription = flavorText.get("flavor_text").toString().replace("\n", " ").replace("\f", " ");;
                String movePower = moveResponse.get("power") != null ? moveResponse.get("power").toString() : null;
                String moveAccuracy = moveResponse.get("accuracy") != null ? moveResponse.get("accuracy").toString() : null;
                String movePP = moveResponse.get("pp") != null ? moveResponse.get("pp").toString() : null;
                String moveCategory = (String) damageClass.get("name");

                moveInfo.put("name", moveName);
                moveInfo.put("description", moveDescription);
                moveInfo.put("power", movePower);
                moveInfo.put("accuracy", moveAccuracy);
                moveInfo.put("pp", movePP);
                moveInfo.put("category", moveCategory);

                moves.add(moveInfo);

            } catch (Exception e) {
                Map<String, String> errorMap = new HashMap<>();
                errorMap.put("error", e.toString());
                List<Map<String, String>> errorList = new ArrayList<>();
                errorList.add(errorMap);
                return errorList;
            }
        }
        return moves;
    }
}
