package com.pragma.powerup.plazoleta.application.dto.request;

import com.pragma.powerup.plazoleta.domain.model.Plato;

public class OrdenDto {

    private Long cantidad;
    private Plato plato;


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
