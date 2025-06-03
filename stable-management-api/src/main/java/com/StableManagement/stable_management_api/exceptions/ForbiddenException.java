package com.StableManagement.stable_management_api.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message){
        super(message);
    }
}
