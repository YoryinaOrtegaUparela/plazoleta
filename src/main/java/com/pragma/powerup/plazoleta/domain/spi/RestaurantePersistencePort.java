package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.infraestructure.exception.NoDataFoundException;

public interface RestaurantePersistencePort {

    public void guardarRestaurante(Restaurante restauranteNuevo);
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws NoDataFoundException;
}
