package com.pokeset.model;

public class Response<T> {
    private String status;
    private String message;
    private T data;

    public Response(String status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(String status, String message){
        this.status = status;
        this.message = message;
    }

    public Response(){}

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

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
