package com.pragma.powerup.plazoleta.application.dto;

import com.pragma.powerup.plazoleta.infraestructure.exception.ValidationRequestException;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlatoRequestDto {

    @NotNull(message = "El atributo nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El atributo idCategoria es obligatorio")
    private Long idCategoria;

    @NotNull(message = "El atributo descripcion es obligatorio")
    private String descripcion;

    @NotNull(message = "El atributo precio es obligatorio")
    private String precio;

    @NotNull(message = "El atributo urlImagen es obligatorio")
    private String urlImagen;

    @NotNull(message = "El atributo idRestaurante es obligatorio")
    private Long idRestaurante;

    private boolean verificarPrecioEsEntero(String precio) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(precio);
        if (mather.find()) {
                return true;
        } else {
            throw new ValidationRequestException("El atributo precio debe ser un entero positivo");
        }
    }

    private boolean precioEsMayorQueCero(String precio){
        Long precioLong = Long.parseLong(precio);
        if(precioLong>0){
            return true;
        }else {
            throw new ValidationRequestException("El atributo precio debe ser mayor a 0");
        }
    }

    private boolean precioEsValido(String precio) {
        if (verificarPrecioEsEntero(precio) && precioEsMayorQueCero(precio)) {
            return true;
        } else {
            return false;
        }
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        if(precioEsValido(precio)){
            this.precio = precio;
        }
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
}
