package com.example.proyecto.exception;

public class DataNotFoundException extends com.example.proyecto.exception.GeneralRuntimeException{
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
