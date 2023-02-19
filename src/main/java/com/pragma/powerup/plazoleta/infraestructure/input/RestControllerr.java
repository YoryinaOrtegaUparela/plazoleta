package com.pragma.powerup.plazoleta.infraestructure.input;

import com.pragma.powerup.plazoleta.application.dto.CambioPlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import com.pragma.powerup.plazoleta.infraestructure.exception.ValidationRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/plazoleta")
public class RestControllerr {

    private RestauranteHandler restauranteHandler;
    private PlatoHandler platoHandler;

    private static final String ERROR = "Error";
    private static final String STATUS_CODE = "Status_Code";

    public RestControllerr(RestauranteHandler restauranteHandler, PlatoHandler platoHandler) {
        this.restauranteHandler = restauranteHandler;
        this.platoHandler = platoHandler;
    }

    @PostMapping("/crearRestaurante")
    public ResponseEntity<Void> crearRestaurante(@Valid @RequestBody RestauranteRequestDto restauranteRequestDto){
        restauranteHandler.crearRestaurante(restauranteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/crearPlato")
    public ResponseEntity<Void> crearPlato(@Valid @RequestBody PlatoRequestDto platoRequestDto){
        platoHandler.crearPlato(platoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/modificarPlato")
    public ResponseEntity<Void> modificarPlato(@Valid @RequestBody CambioPlatoRequestDto cambioPlatoRequestDto){
        platoHandler.modificarPlato(cambioPlatoRequestDto);
        return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(ValidationRequestException.class)
    public ResponseEntity<Map<String, String>> handleNoValidRolException(
            ValidationRequestException validationRequestException) {

        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put(ERROR, validationRequestException.getMessage());
        stringStringMap.put(STATUS_CODE, HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(stringStringMap);
    }
}
