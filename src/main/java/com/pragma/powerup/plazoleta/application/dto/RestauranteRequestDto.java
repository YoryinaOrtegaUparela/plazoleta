package com.pragma.powerup.plazoleta.application.dto;


import javax.validation.constraints.NotNull;

public class RestauranteRequestDto {

    @NotNull(message = "El atributo nombre es obligatorio")
    private String nombre;
    @NotNull(message = "El atributo nit es obligatorio")
    private Long nit;
    @NotNull(message = "El atributo direccion es obligatorio")
    private String direccion;
    @NotNull(message = "El atributo idPropietario es obligatorio")
    private Long idPropietario;
    @NotNull(message = "El atributo telefono es obligatorio")
    private String telefono;
    @NotNull(message = "El atributo urlLogo es obligatorio")
    private String urlLogo;

    public RestauranteRequestDto(String nombre, Long nit, String direccion, Long idPropietario, String telefono, String urlLogo) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.idPropietario = idPropietario;
        this.telefono = telefono;
        this.urlLogo = urlLogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
