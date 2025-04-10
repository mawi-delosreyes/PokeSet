package com.pokeset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "PokemonPresetData")
@Entity
public class PokemonPresetData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preset_data_id")
    private Integer presetDataId;

    @Column(name = "preset_id")
    private Integer presetId;

    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Column(name = "move1_id")
    private Integer move1_id;

    @Column(name = "move2_id")
    private Integer move2_id;

    @Column(name = "move3_id")
    private Integer move3_id;

    @Column(name = "move4_id")
    private Integer move4_id;

    @Column(name = "item")
    private String item;

    @Column(name = "ability")
    private String ability;

    @Column(name = "nature")
    private String nature;

    @Column(name = "battle_mechanic")
    private String battleMechanic;

    @Column(name = "type")
    private String type;

    @Column(name = "ev_id")
    private Integer evId;

    @Column(name = "used")
    private Boolean used;

    public Integer getPresetDataId() {
        return presetDataId;
    }

    public void setPresetDataId(Integer presetDataId) {
        this.presetDataId = presetDataId;
    }

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public Integer getMove1_id() {
        return move1_id;
    }

    public void setMove1_id(Integer move1_id) {
        this.move1_id = move1_id;
    }

    public Integer getMove2_id() {
        return move2_id;
    }

    public void setMove2_id(Integer move2_id) {
        this.move2_id = move2_id;
    }

    public Integer getMove3_id() {
        return move3_id;
    }

    public void setMove3_id(Integer move3_id) {
        this.move3_id = move3_id;
    }

    public Integer getMove4_id() {
        return move4_id;
    }

    public void setMove4_id(Integer move4_id) {
        this.move4_id = move4_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getBattleMechanic() {
        return battleMechanic;
    }

    public void setBattleMechanic(String battleMechanic) {
        this.battleMechanic = battleMechanic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEvId() {
        return evId;
    }

    public void setEvId(Integer evId) {
        this.evId = evId;
    }

    public Boolean isUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}
