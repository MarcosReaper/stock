package com.marcoscervera.stock.core.exception;

public class RepositoryException extends RuntimeException{

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
