package com.pokeset.util;

import com.pokeset.model.IndividualPresetModel;
import com.pokeset.model.PresetListModel;
import com.pokeset.model.Response;
import lombok.experimental.UtilityClass;

import java.util.HashMap;

@UtilityClass
public class ResponseUtil {

    public Response generatedResponse(String status, String message) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }

    public Response generatedResponse(String status, String message, HashMap data) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public Response generatedResponse(String status, String message, IndividualPresetModel individualPresetModel){
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(individualPresetModel);
        return response;
    }

    public Response generatedResponse(String status, String message, PresetListModel presetListModel) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(presetListModel);
        return response;
    }

}
