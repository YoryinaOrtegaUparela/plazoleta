package com.pragma.powerup.plazoleta.application.handler;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;

public interface RestauranteHandler {

    public RestauranteResponseDto crearRestaurante(RestauranteRequestDto restauranteNuevo);
}
