package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;

public interface RestaurantePersistencePort {

    public Restaurante guardarRestaurante(Restaurante restauranteNuevo);
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws PlazoletaNoDataFoundException;
}
