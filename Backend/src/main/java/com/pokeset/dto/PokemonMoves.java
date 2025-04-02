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
@Table(name = "PokemonMoves")
@Entity
public class PokemonMoves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "move_id")
    private Integer moveId;

    @Column(name = "move_name")
    private String moveName;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    public Integer getMoveId() {
        return moveId;
    }

    public void setMoveId(Integer moveId) {
        this.moveId = moveId;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
}
