package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;

public interface RestauranteServicePort {

    public void crearRestaurante(Restaurante restauranteNuevo);
    public boolean validarSiExisteRestaurante(Long idRestaurante);
}
