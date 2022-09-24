package com.example.project.exception;

public class BusinessException extends com.example.project.exception.GeneralRuntimeException{
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String translationKey) {
        super(message, translationKey);
    }
}
