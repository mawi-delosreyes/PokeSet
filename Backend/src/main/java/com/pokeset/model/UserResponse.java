package com.pokeset.model;

public class UserResponse<T> extends BaseResponse{

    private String username;
    private String email;
    private Integer userId;

    public UserResponse(){}

    public UserResponse(String status, String message, String username, Integer userId, String email) {
        this.status = status;
        this.message = message;
        this.username = username;
        this.userId = userId;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
