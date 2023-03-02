package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.helper.ValidadorDataDeRestaurante;
import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import com.pragma.powerup.plazoleta.domain.exception.OperacionNoPermitidaException;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.UsuarioRemotePort;

import java.util.List;

public class RestauranteUseCase implements RestauranteServicePort {

    private static final String ROL_PROPIETARIO = "PROPIETARIO";
    private RestaurantePersistencePort restaurantePersistencePort;
    private UsuarioRemotePort usuarioRemotePort;

    public RestauranteUseCase(RestaurantePersistencePort restaurantePersistencePort, UsuarioRemotePort usuarioRemotePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.usuarioRemotePort = usuarioRemotePort;
    }

    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) {

        ValidadorDataDeRestaurante.validarDataParaCreareRestaurante(restaurante);

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = usuarioRemotePort
                .validarRolUsuario(restaurante.getIdPropietario());

        if (!usuarioRemoteResponseDto.getRol().equalsIgnoreCase(ROL_PROPIETARIO)) {
            throw new OperacionNoPermitidaException("El id propietario suministrado no tiene un rol de PROPIETARIO asignado");
        }

        Restaurante restauranteCreado = restaurantePersistencePort.crearRestaurante(restaurante);
        return restauranteCreado;
    }

    @Override
    public boolean validarSiExisteRestaurante(Long idRestaurante) {
        return restaurantePersistencePort.validarSiRestauranteExiste(idRestaurante);
    }

    @Override
    public List<Restaurante> listarRestaurantes(RestauranteRequestDto restauranteRequestDto) {
        List<Restaurante> listaRestaurantes = restaurantePersistencePort.listarRestaurantes(restauranteRequestDto);
        return listaRestaurantes;
    }

}
