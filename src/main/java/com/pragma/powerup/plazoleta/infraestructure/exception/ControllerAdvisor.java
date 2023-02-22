package com.pragma.powerup.plazoleta.infraestructure.exception;

import com.pragma.powerup.plazoleta.domain.exception.OperacionNoPermitidaException;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.exception.ValidationRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String ERROR = "Error";
    private static final String STATUS_CODE = "Status_Code";

    @ExceptionHandler(ValidationRequestException.class)
    public ResponseEntity<Map<String, String>> handlevalidationRequestException(
            ValidationRequestException validationRequestException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, validationRequestException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }

    @ExceptionHandler(InformacionNoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleInformacionNoEncontradaException(
            InformacionNoEncontradaException informacionNoEncontradaException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, informacionNoEncontradaException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }

    @ExceptionHandler(OperacionNoPermitidaException.class)
    public ResponseEntity<Map<String, String>> handleOperacionNoPermitidaException(
            OperacionNoPermitidaException operacionNoPermitidaException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, operacionNoPermitidaException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(stringStringMap);
    }
}
