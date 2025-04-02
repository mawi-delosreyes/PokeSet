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

    @Column(name = "move_1")
    private Integer move1;

    @Column(name = "move_2")
    private Integer move2;

    @Column(name = "move_3")
    private Integer move3;

    @Column(name = "move_4")
    private Integer move4;

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

    public Integer getMove1() {
        return move1;
    }

    public void setMove1(Integer move1) {
        this.move1 = move1;
    }

    public Integer getMove2() {
        return move2;
    }

    public void setMove2(Integer move2) {
        this.move2 = move2;
    }

    public Integer getMove3() {
        return move3;
    }

    public void setMove3(Integer move3) {
        this.move3 = move3;
    }

    public Integer getMove4() {
        return move4;
    }

    public void setMove4(Integer move4) {
        this.move4 = move4;
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
