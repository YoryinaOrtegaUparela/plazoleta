package com.pragma.powerup.plazoleta.domain.exception;

public class InformacionNoEncontradaException extends RuntimeException{

    public InformacionNoEncontradaException(){}

    public InformacionNoEncontradaException(String message){
        super(message);
    }
}
