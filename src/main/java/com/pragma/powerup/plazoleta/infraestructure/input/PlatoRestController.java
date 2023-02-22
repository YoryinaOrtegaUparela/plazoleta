package com.pragma.powerup.plazoleta.infraestructure.input;

import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/plazoleta/plato")
public class PlatoRestController {

    private PlatoHandler platoHandler;

    public PlatoRestController(PlatoHandler platoHandler) {
        this.platoHandler = platoHandler;
    }

    @Operation(description = "Permitir la Creacion de un plato dentro del sistema")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/crearPlato")
    public ResponseEntity<PlatoResponseDto> crearPlato( @RequestBody PlatoRequestDto platoRequestDto){
        PlatoResponseDto platoResponseDto = platoHandler.crearPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.CREATED);
    }

    @Operation(description = "Permite modificar parcialmente un plato dentro del sistema")
    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping("/modificarPlato")
    public ResponseEntity<PlatoResponseDto> modificarPlato
            ( @RequestBody PlatoRequestDto platoRequestDto){
        PlatoResponseDto platoResponseDto = platoHandler.modificarPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.OK);
    }

    @Operation(description = "Permite activar/desactivar platos en el menú \n" +
            "para dejar de ofrecer el producto en el menú")
    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping("/habilitarDeshabilitarPlato")
    public ResponseEntity<PlatoResponseDto> habilitarDeshabilitarPlato
            ( @RequestBody PlatoRequestDto platoRequestDto){
            PlatoResponseDto platoResponseDto = platoHandler.activarDesactivarPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.OK);
    }

}
