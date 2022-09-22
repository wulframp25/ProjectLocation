package com.example.proyecto.exception;

public class BusinessException extends com.example.proyecto.exception.GeneralRuntimeException{
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String translationKey) {
        super(message, translationKey);
    }
}
