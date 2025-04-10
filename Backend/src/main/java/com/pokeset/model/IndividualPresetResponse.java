package com.pokeset.model;

public class IndividualPresetResponse<T> extends BaseResponse {

    private IndividualPresetModel individualPresetModel;

    public IndividualPresetResponse(){}

    public IndividualPresetResponse(String status, String message, IndividualPresetModel individualPresetModel) {
        this.status = status;
        this.message = message;
        this.individualPresetModel = individualPresetModel;
    }

    public IndividualPresetModel getIndividualPresetModel() {
        return individualPresetModel;
    }

    public void setIndividualPresetModel(IndividualPresetModel individualPresetModel) {
        this.individualPresetModel = individualPresetModel;
    }
}
