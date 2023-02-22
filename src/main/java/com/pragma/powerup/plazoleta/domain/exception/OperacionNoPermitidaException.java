package com.pragma.powerup.plazoleta.domain.exception;

public class OperacionNoPermitidaException extends RuntimeException{

    public OperacionNoPermitidaException(){
        super();
    }
    public OperacionNoPermitidaException(String message){
        super(message);
    }
}
