package com.pragma.powerup.plazoleta.infraestructure.exception;

public class ValidationRequestException extends RuntimeException {

    public ValidationRequestException() {
    }

    public ValidationRequestException(String message) {
        super(message);
    }

}
