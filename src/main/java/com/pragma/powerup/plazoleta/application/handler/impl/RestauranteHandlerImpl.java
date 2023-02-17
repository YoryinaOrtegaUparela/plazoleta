package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.RestauranteRequestDto;
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
    public void crearRestaurante(RestauranteRequestDto restauranteRequestDto) {
        Restaurante restaurante = restauranteMapper.restauranteDtoToRestaurante(restauranteRequestDto);
        restauranteServicePort.crearRestaurante(restaurante);
    }
}
