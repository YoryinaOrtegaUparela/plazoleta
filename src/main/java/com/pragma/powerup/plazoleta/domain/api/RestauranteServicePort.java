package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;

public interface RestauranteServicePort {

    public Restaurante crearRestaurante(Restaurante restaurante);
    public boolean validarSiExisteRestaurante(Long idRestaurante);
}
