package com.pragma.powerup.plazoleta.application.dto;

import com.pragma.powerup.plazoleta.infraestructure.exception.ValidationRequestException;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CambioPlatoRequestDto {

    @NotNull(message = "El atributo idCategoria es obligatorio")
    private Long idPlato;

    @NotNull(message = "El atributo descripcion es obligatorio")
    private String descripcion;

    @NotNull(message = "El atributo precio es obligatorio")
    private String precio;


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

    public Long getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
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
        this.precio = precio;
    }
}
