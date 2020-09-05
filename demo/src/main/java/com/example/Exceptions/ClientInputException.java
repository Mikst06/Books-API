package com.example.Exceptions;

public class ClientInputException extends IllegalArgumentException {

    public ClientInputException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
