package com.pragma.powerup.plazoleta.infraestructure.input;

import com.pragma.powerup.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import com.pragma.powerup.plazoleta.infraestructure.security.impl.MyUserDetailService;
import com.pragma.powerup.plazoleta.infraestructure.security.impl.MyUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/plazoleta/restaurante")
public class RestauranteRestController {

    private RestauranteHandler restauranteHandler;


    public RestauranteRestController(RestauranteHandler restauranteHandler) {
        this.restauranteHandler = restauranteHandler;
    }

    @Operation(description = "Permitir la Creacion de un restaurante dentro del sistema.")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/creaRestaurante")
    public ResponseEntity<RestauranteResponseDto> crearRestaurante
            (@RequestBody RestauranteRequestDto restauranteRequestDto){
        RestauranteResponseDto restauranteResponseDto = restauranteHandler.crearRestaurante(restauranteRequestDto);

        return new ResponseEntity<RestauranteResponseDto>(restauranteResponseDto,HttpStatus.CREATED);
    }

    @Operation(description = "Permitir al cliente listar todos los restaurantes disponibles.")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/listaRestaurantes")
    public ResponseEntity<ListaRestaurantesResponseDto> listarRestaurantes
            (@RequestBody RestauranteRequestDto restauranteRequestDto){
        ListaRestaurantesResponseDto listaRestaurantesResponseDto =
                restauranteHandler.listarRestaurantes(restauranteRequestDto);

        return new ResponseEntity<ListaRestaurantesResponseDto>(listaRestaurantesResponseDto,HttpStatus.OK);
    }

    @Operation(description = "Permitir al cliente realizar un pedido a un restaurante.")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/pedido")
    public ResponseEntity<PedidoResponseDto> realizarPedido
            (@RequestBody PedidoRequestDto pedidoRequestDto, Authentication authentication){
        MyUserDetails myUserDetails=(MyUserDetails)authentication.getPrincipal();
        Long id = myUserDetails.getUsuarioRemoteResponseDto().getId();

        pedidoRequestDto.setIdCliente(id);

        PedidoResponseDto pedidoResponseDto =
                restauranteHandler.realizarPedido(pedidoRequestDto);

        return new ResponseEntity<PedidoResponseDto>(pedidoResponseDto,HttpStatus.CREATED);
    }

}
