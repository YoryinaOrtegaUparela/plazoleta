package com.pragma.powerup.plazoleta.application.dto.response;

import java.util.List;

public class ListaRestaurantesResponseDto {

    private List<RestauranteResponseDto> listaDeRestaurantes;

    public List<RestauranteResponseDto> getListaDeRestaurantes() {
        return listaDeRestaurantes;
    }

    public void setListaDeRestaurantes(List<RestauranteResponseDto> listaDeRestaurantes) {
        this.listaDeRestaurantes = listaDeRestaurantes;
    }
}
