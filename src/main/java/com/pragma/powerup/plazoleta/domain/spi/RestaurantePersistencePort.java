package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;

public interface RestaurantePersistencePort {

    public void guardarRestaurante(Restaurante restauranteNuevo);
}
