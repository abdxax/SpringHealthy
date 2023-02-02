package com.example.heathapi.handlingErrors;

public class ApiException extends RuntimeException{
    public ApiException(String msg){
        super(msg);
    }
}
