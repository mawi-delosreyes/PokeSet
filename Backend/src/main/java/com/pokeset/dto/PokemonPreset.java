package com.pokeset.dto;

import lombok.*;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "PokemonPreset")
@Entity
public class PokemonPreset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preset_id")
    private Integer presetId;

    @Column(name = "preset_name")
    private String presetName;

    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_arrange")
    private Integer teamArrange;

    public Integer getPresetId() {
        return presetId;
    }

    public void setPresetId(Integer presetId) {
        this.presetId = presetId;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
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

    public Integer getTeamArrange() {
        return teamArrange;
    }

    public void setTeamArrange(Integer teamArrange) {
        this.teamArrange = teamArrange;
    }
}
