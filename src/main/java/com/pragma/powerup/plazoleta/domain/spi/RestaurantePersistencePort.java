package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;

public interface RestaurantePersistencePort {

    public Restaurante crearRestaurante(Restaurante restaurante);
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws InformacionNoEncontradaException;
}
