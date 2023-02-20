package com.pragma.powerup.plazoleta.domain.exception;

public class OperationNotAllowedException extends RuntimeException{

    public OperationNotAllowedException(){
        super();
    }
    public OperationNotAllowedException(String message){
        super(message);
    }
}
