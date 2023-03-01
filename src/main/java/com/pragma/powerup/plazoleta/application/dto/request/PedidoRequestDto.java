package com.pragma.powerup.plazoleta.application.dto.request;

import com.pragma.powerup.plazoleta.domain.model.Orden;

import java.util.List;

public class PedidoRequestDto {

    private Long idRestaurante;
    private List<Orden> orden;


    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public List<Orden> getOrden() {
        return orden;
    }

    public void setOrden(List<Orden> orden) {
        this.orden = orden;
    }
}
