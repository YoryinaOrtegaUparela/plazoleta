package com.pragma.powerup.plazoleta.application.dto;


import com.pragma.powerup.plazoleta.infraestructure.exception.ValidationRequestException;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestauranteRequestDto {

    @NotNull(message = "El atributo nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El atributo nit es obligatorio")
    private String nit;

    @NotNull(message = "El atributo direccion es obligatorio")
    private String direccion;

    @NotNull(message = "El atributo idPropietario es obligatorio")
    private Long idPropietario;

    @NotNull(message = "El atributo telefono es obligatorio")
    private String telefono;

    @NotNull(message = "El atributo urlLogo es obligatorio")
    private String urlLogo;

    private String estructuraNombreEsCorrecta(String nombre) {
        Pattern pattern = Pattern
                .compile("^[a-zA-Z0-9]*[a-zA-Z][a-zA-Z0-9]*$");
        Matcher mather = pattern.matcher(nombre);
        if (mather.find()) {
            return nombre;
        } else {
            throw new ValidationRequestException("El atributo nombre debe contener letras de la A-Z y puede contener números, pero no se permiten nombres con sólo números.");
        }
    }

    /**
     * Método para que verificar que el atributo nit sea solo numerico
     * @param nit
     * @return nit
     */
    private String verificarNit(String nit) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(nit);
        if (mather.find()) {
            return nit;
        } else {
            throw new ValidationRequestException("El atributo documentoIdentidad debe ser numerico");
        }
    }

    private boolean telefonoEsValido(String telefono) {
        if (estructuraTelefonoEsCorrecta(telefono) && tamanoTelefonoEsCorrecto(telefono)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para validar que el telefono cuente con máximo 13 caracteres
     *
     * @param telefono
     * @return boolean
     */
    private boolean tamanoTelefonoEsCorrecto(String telefono) {
        if (telefono.length() > 13) {
            throw new ValidationRequestException("El número de caracteres del atributo telefono es mayor a 13");
        }
        return true;
    }

    /**
     * Método para validar que el atributo telefono sea unicamente numerico y pueda contener el símbolo +
     *
     * @param telefono
     * @return telefono
     */
    private boolean estructuraTelefonoEsCorrecta(String telefono) {
        Pattern pattern = Pattern
                .compile("^\\+?\\d+$");
        Matcher mather = pattern.matcher(telefono);
        if (mather.find()) {
            return true;
        } else {
            throw new ValidationRequestException("El atributo telefono debe ser numerico y puede iniciar con +");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = estructuraNombreEsCorrecta(nombre);
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = verificarNit(nit);
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
        if(telefonoEsValido(telefono)) {
            this.telefono = telefono;
        }
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
