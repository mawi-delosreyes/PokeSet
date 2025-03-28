package com.pokeset.model;

public class IndividualPresetModel extends EvModel {
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    private String item;
    private String ability;
    private String nature;
    private String battleMechanic;
    private String battleMechanicType;

    private Integer presetId;
    private String presetName;


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

    public String getBattleMechanicType() {
        return battleMechanicType;
    }

    public void setBattleMechanicType(String battleMechanicType) {
        this.battleMechanicType = battleMechanicType;
    }

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
}
