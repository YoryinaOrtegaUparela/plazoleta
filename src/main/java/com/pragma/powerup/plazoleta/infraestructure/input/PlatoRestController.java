package com.pragma.powerup.plazoleta.infraestructure.input;

import com.pragma.powerup.plazoleta.application.dto.request.MenuRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.MenuResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/plazoleta/plato")
public class PlatoRestController {

    private PlatoHandler platoHandler;

    public PlatoRestController(PlatoHandler platoHandler) {
        this.platoHandler = platoHandler;
    }

    @Operation(description = "Permitir la Creacion de un plato dentro del sistema")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/creaPlato")
    public ResponseEntity<PlatoResponseDto> crearPlato( @RequestBody PlatoRequestDto platoRequestDto){
        PlatoResponseDto platoResponseDto = platoHandler.crearPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.CREATED);
    }

    @Operation(description = "Permite modificar parcialmente un plato dentro del sistema")
    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping("/modificaPlato")
    public ResponseEntity<PlatoResponseDto> modificarPlato
            ( @RequestBody PlatoRequestDto platoRequestDto){
        PlatoResponseDto platoResponseDto = platoHandler.modificarPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.OK);
    }

    @Operation(description = "Permite activar/desactivar platos en el menú \n" +
            "para dejar de ofrecer el producto en el menú")
    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping("/estadoPlato")
    public ResponseEntity<PlatoResponseDto> habilitarODeshabilitarPlato
            ( @RequestBody PlatoRequestDto platoRequestDto){
            PlatoResponseDto platoResponseDto = platoHandler.activarODesactivarPlato(platoRequestDto);
        return new ResponseEntity<PlatoResponseDto>(platoResponseDto, HttpStatus.OK);
    }

    @Operation(description = "Permitir al cliente listar el menú (platos agrepados por categorias) " +
            "de cada restaurante al que da clic.")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/menu")
    public ResponseEntity<MenuResponseDto> menu( @RequestBody MenuRequestDto menuRequestDto){
      MenuResponseDto menuResponseDto = platoHandler.obtenerMenu(menuRequestDto);

        return new ResponseEntity<MenuResponseDto>(menuResponseDto, HttpStatus.OK);
    }

}
