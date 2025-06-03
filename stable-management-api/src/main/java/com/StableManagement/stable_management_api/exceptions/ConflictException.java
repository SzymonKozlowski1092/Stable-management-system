package com.StableManagement.stable_management_api.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message){
        super(message);
    }
}