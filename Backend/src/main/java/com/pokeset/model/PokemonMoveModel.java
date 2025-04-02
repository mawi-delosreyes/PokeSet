package com.pokeset.model;

public class PokemonMoveModel {
    private Integer moveId;
    private String moveName;
    private String type_1;
    private String type_2;

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

    public String getType_1() {
        return type_1;
    }

    public void setType_1(String type_1) {
        this.type_1 = type_1;
    }

    public String getType_2() {
        return type_2;
    }

    public void setType_2(String type_2) {
        this.type_2 = type_2;
    }
}
