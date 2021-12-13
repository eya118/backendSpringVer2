package com.example.projet_integration.exception;

public class CategoryException extends RuntimeException {
    public CategoryException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CategoryException(String exMessage) {
        super(exMessage);
    }
}
