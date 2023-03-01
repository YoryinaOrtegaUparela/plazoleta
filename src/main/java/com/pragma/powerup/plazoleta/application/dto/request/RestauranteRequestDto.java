package com.pragma.powerup.plazoleta.application.dto.request;


public class RestauranteRequestDto {
    private String nombre;
    private String nit;
    private String direccion;
    private Long idPropietario;
    private String telefono;
    private String urlLogo;
    private Long numeroRegistros;
    private Long pagina;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
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

    public Long getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(Long numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    public Long getPagina() {
        return pagina;
    }

    public void setPagina(Long pagina) {
        this.pagina = pagina;
    }
}
