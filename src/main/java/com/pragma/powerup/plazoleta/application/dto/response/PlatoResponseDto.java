package com.pragma.powerup.plazoleta.application.dto.response;

public class PlatoResponseDto {

    private String nombre;
    private Long idCategoria;
    private String descripcion;
    private String precio;
    private Long idRestaurante;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
