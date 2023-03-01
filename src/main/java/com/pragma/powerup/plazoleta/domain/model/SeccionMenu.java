package com.pragma.powerup.plazoleta.domain.model;

import com.pragma.powerup.plazoleta.domain.model.Categoria;
import com.pragma.powerup.plazoleta.domain.model.Plato;

import java.util.List;

public class SeccionMenu {

    private String categoria;
    private List<Plato> platos;


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
}
