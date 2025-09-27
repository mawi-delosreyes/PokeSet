package com.pokeset.model;

import java.util.List;

public class ListResponse<T> extends BaseResponse {

    private List list;

    public ListResponse(){}

    public ListResponse(String status, String message, List list){
        this.status = status;
        this.message = message;
        this.list = list;
    }

    public List getList(){
        return list;
    }

    public void setList(List list){
        this.list = list;
    }
}
