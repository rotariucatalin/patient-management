package com.pm.patientservice.exception;

public class ObjectDtoNotValidException extends RuntimeException{

    public ObjectDtoNotValidException(String message) {
        super(message);
    }
}
