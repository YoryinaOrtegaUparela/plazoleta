package com.pragma.powerup.plazoleta.infraestructure.input;

import com.pragma.powerup.plazoleta.application.dto.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/plazoleta")
public class RestControllerr {

    private RestauranteHandler restauranteHandler;

    public RestControllerr(RestauranteHandler restauranteHandler) {
        this.restauranteHandler = restauranteHandler;
    }

    @PostMapping("/crearRestaurante")
    public ResponseEntity<Void> crearRestaurante(@Valid @RequestBody RestauranteRequestDto restauranteRequestDto){
        restauranteHandler.crearRestaurante(restauranteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
