package com.pragma.powerup.plazoleta.domain.exception;

public class PlazoletaNoDataFoundException extends RuntimeException{

    public PlazoletaNoDataFoundException(){}

    public PlazoletaNoDataFoundException(String message){
        super(message);
    }
}
