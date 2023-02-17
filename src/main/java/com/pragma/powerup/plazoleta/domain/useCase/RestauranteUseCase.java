package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;

public class RestauranteUseCase implements RestauranteServicePort {

    private RestaurantePersistencePort restaurantePersistencePort;

    public RestauranteUseCase(RestaurantePersistencePort restaurantePersistencePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
    }

    @Override
    public void crearRestaurante(Restaurante restauranteNuevo) {
        restaurantePersistencePort.guardarRestaurante(restauranteNuevo);
    }
}
