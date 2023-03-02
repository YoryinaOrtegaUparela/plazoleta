package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;

import java.util.List;

public interface RestaurantePersistencePort {

    public Restaurante crearRestaurante(Restaurante restaurante);
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws InformacionNoEncontradaException;
    public List<Restaurante> listarRestaurantes(RestauranteRequestDto restauranteRequestDto);

}
