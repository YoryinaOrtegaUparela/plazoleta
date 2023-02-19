package com.pragma.powerup.plazoleta.infraestructure.exception;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(){}

    public NoDataFoundException(String message){
        super(message);
    }
}
