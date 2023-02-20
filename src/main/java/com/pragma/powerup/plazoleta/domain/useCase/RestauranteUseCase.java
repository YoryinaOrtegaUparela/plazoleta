package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;
import com.pragma.powerup.plazoleta.domain.helper.RestauranteDataValidator;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;

public class RestauranteUseCase implements RestauranteServicePort {

    private RestaurantePersistencePort restaurantePersistencePort;

    public RestauranteUseCase(RestaurantePersistencePort restaurantePersistencePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
    }

    @Override
    public Restaurante crearRestaurante(Restaurante restauranteNuevo) {
        RestauranteDataValidator.validarRestaurante(restauranteNuevo);
        Restaurante restauranteCreado = restaurantePersistencePort.guardarRestaurante(restauranteNuevo);
        return restauranteCreado;
    }

    @Override
    public void validarSiExisteRestaurante(Long idRestaurante) {
        boolean restauranteExiste = restaurantePersistencePort.validarSiRestauranteExiste(idRestaurante);
        if(!restauranteExiste){
            throw new PlazoletaNoDataFoundException("El idRestaurante " + idRestaurante + " no existe.");
        }


    }
}
