package com.pokeset.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "PokemonList")
@Entity
public class PokemonList {

    @Id
    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Column(name = "pokemon_name")
    private String pokemonName;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    public Integer getPokemonId(){
        return pokemonId;
    }

    private void setPokemonId(){
        this.pokemonId = pokemonId;
    }

    public String getPokemonName(){
        return pokemonName;
    }

    private void setPokemonName(){
        this.pokemonName = pokemonName;
    }

    public String getType1(){
        return type1;
    }

    private void setType1(){
        this.type1 = type1;
    }

    public String getType2(){
        return type2;
    }

    private void setType2(){
        this.type2 = type2;
    }

}
