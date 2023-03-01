package com.pragma.powerup.plazoleta.infraestructure.persistence.entity;

import java.math.BigInteger;

public class PlatoConCategoria {

    private String nombre;
    private String descripcion;
    private BigInteger precio;
    private String nombreCategoria;

    public PlatoConCategoria(String nombre, String descripcion, BigInteger precio, String nombreCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }
}
