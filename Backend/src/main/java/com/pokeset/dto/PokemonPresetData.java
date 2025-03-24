package com.pokeset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String move1;

    @Column(name = "move_2")
    private String move2;

    @Column(name = "move_3")
    private String move3;

    @Column(name = "move_4")
    private String move4;

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

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public String getMove3() {
        return move3;
    }

    public void setMove3(String move3) {
        this.move3 = move3;
    }

    public String getMove4() {
        return move4;
    }

    public void setMove4(String move4) {
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
