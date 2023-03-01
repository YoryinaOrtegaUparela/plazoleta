package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;

import java.util.List;

public interface RestauranteServicePort {

    public Restaurante crearRestaurante(Restaurante restaurante);
    public boolean validarSiExisteRestaurante(Long idRestaurante);

    public List<Restaurante> listarRestaurantes(RestauranteRequestDto restauranteRequestDto);
}
