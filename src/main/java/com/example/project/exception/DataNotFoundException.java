package com.example.project.exception;

public class DataNotFoundException extends com.example.project.exception.GeneralRuntimeException{
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
