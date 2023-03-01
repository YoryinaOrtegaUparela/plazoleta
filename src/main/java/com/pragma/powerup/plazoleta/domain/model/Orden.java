package com.pragma.powerup.plazoleta.domain.model;

public class Orden {

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
