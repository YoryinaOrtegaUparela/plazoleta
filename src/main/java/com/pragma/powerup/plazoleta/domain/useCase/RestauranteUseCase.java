package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.application.dto.UsuarioRemoteResponseDto;
import com.pragma.powerup.plazoleta.domain.exception.OperationNotAllowedException;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.UsuarioRemotePort;

public class RestauranteUseCase implements RestauranteServicePort {

    private static final String ROL_PROPIETARIO = "PROPIETARIO";

    private RestaurantePersistencePort restaurantePersistencePort;

    private UsuarioRemotePort usuarioRemotePort;

    public RestauranteUseCase(RestaurantePersistencePort restaurantePersistencePort, UsuarioRemotePort usuarioRemotePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.usuarioRemotePort = usuarioRemotePort;
    }

    @Override
    public void crearRestaurante(Restaurante restauranteNuevo) {

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = usuarioRemotePort
                .validarRolUsuario(restauranteNuevo.getIdPropietario());

        if (!usuarioRemoteResponseDto.getRol().equalsIgnoreCase(ROL_PROPIETARIO)) {
            throw new OperationNotAllowedException("El id propietario suministrado no tiene un rol de PROPIETARIO asignado");

        }

        restaurantePersistencePort.guardarRestaurante(restauranteNuevo);
    }

    @Override
    public boolean validarSiExisteRestaurante(Long idRestaurante) {

        return false;
    }
}
