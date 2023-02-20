package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import com.pragma.powerup.plazoleta.application.mapper.RestauranteMapper;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import org.springframework.stereotype.Service;

@Service
public class RestauranteHandlerImpl implements RestauranteHandler {

    private RestauranteMapper restauranteMapper;
    private RestauranteServicePort restauranteServicePort;

    public RestauranteHandlerImpl(RestauranteMapper restauranteMapper, RestauranteServicePort restauranteServicePort) {
        this.restauranteMapper = restauranteMapper;
        this.restauranteServicePort = restauranteServicePort;
    }

    @Override
    public RestauranteResponseDto crearRestaurante(RestauranteRequestDto restauranteRequestDto) {
        Restaurante restaurante = restauranteMapper.restauranteDtoToRestaurante(restauranteRequestDto);
        Restaurante restauranteCreado = restauranteServicePort.crearRestaurante(restaurante);
        RestauranteResponseDto restauranteResponseDto = restauranteMapper.restauranteToRestauranteResponseDto(restauranteCreado);
        return restauranteResponseDto;
    }
}
