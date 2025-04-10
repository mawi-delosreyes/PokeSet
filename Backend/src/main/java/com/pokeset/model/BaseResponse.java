package com.pokeset.model;

public class BaseResponse<T> {
    String status;
    String message;

    public BaseResponse(){}

    public BaseResponse(String status, String message){
        this.status = status;
        this.message = message;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
