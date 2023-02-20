package com.pragma.powerup.plazoleta.infraestructure.exception;

import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;
import com.pragma.powerup.plazoleta.domain.exception.PlazoletaValidationRequestException;
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

    @ExceptionHandler(PlazoletaValidationRequestException.class)
    public ResponseEntity<Map<String, String>> handlevalidationRequestException(
            PlazoletaValidationRequestException plazoletaValidationRequestException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, plazoletaValidationRequestException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }

    @ExceptionHandler(PlazoletaNoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            PlazoletaNoDataFoundException plazoletaNoDataFoundException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, plazoletaNoDataFoundException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }
}
