package com.pragma.powerup.plazoleta.domain.helper;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.exception.ValidationRequestException;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDataDeRestaurante {

    public static Restaurante validarDataParaCreareRestaurante(Restaurante restaurante) {
        validarDataObligatoria(restaurante);
        validarEstructuraData(restaurante);
        return restaurante;
    }

    /**
     * Método para validar que se está cumpliendo con los campos obligatorios para crear un restaurante
     *
     * @param restaurante
     */
    private static void validarDataObligatoria(Restaurante restaurante) {
        if (isNull(restaurante.getNombre())) {
            throw new InformacionNoEncontradaException("El atributo nombre es obligatorio");
        } else if (isNull(restaurante.getNit())) {
            throw new InformacionNoEncontradaException("El atributo nit es obligatorio");
        } else if (isNull(restaurante.getDireccion())) {
            throw new InformacionNoEncontradaException("El atributo direccion es obligatorio");
        } else if (isNull(restaurante.getIdPropietario())) {
            throw new InformacionNoEncontradaException("El atributo idPropietario es obligatorio");
        } else if (isNull(restaurante.getTelefono())) {
            throw new InformacionNoEncontradaException("El atributo telefono es obligatorio");
        } else if (isNull(restaurante.getUrlLogo())) {
            throw new InformacionNoEncontradaException("El atributo urlLogo es obligatorio");
        }
    }

    private static boolean isNull(Object atributo) {
        if (atributo == null) {
            return true;
        }
        return false;
    }

    private static void validarEstructuraData(Restaurante restaurante) {
        estructuraNombreEsCorrecta(restaurante.getNombre());
        estructuraNitEsCorrecta(restaurante.getNit());
        telefonoEsCorrecto(restaurante.getTelefono());
    }

    /**
     * Método para verificar que el nombre cumpla con: contener letras de la A-Z y puede contener números, pero no se permiten nombres con sólo números.
     *
     * @param nombre
     */
    private static void estructuraNombreEsCorrecta(String nombre) {
        Pattern pattern = Pattern
                .compile("^[a-zA-Z0-9]*[a-zA-Z][a-zA-Z0-9]*$");
        Matcher mather = pattern.matcher(nombre);
        if (!mather.find()) {
            throw new ValidationRequestException("El atributo nombre debe contener letras de la A-Z y puede " +
                    "contener números, pero no se permiten nombres con sólo números.");
        }
    }

    /**
     * Método para que verificar que el atributo nit sea solo numerico
     *
     * @param nit
     */
    private static void estructuraNitEsCorrecta(String nit) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(nit);
        if (!mather.find()) {
            throw new ValidationRequestException("El atributo nit debe ser numerico");
        }
    }

    /**
     * Valida que el telefono cumpla con la estructura y tamaño requerido
     * @param telefono
     */

    private static void telefonoEsCorrecto(String telefono) {
        estructuraTelefonoEsCorrecta(telefono);
        tamanoTelefonoEsCorrecto(telefono);
    }

    /**
     * Valida que el tamaño del telefono no sea superior a 13 caracteres
     * @param telefono
     */

    private static void tamanoTelefonoEsCorrecto(String telefono) {
        if (telefono.length() > 13) {
            throw new ValidationRequestException("El número de caracteres del atributo telefono es mayor a 13");
        }
    }

    /**
     * Valida que la estructura del telefono sea numerico y pueda iniciar con +
     * @param telefono
     */
    private static void estructuraTelefonoEsCorrecta(String telefono) {
        Pattern pattern = Pattern
                .compile("^\\+?\\d+$");
        Matcher mather = pattern.matcher(telefono);
        if (!mather.find()) {
            throw new ValidationRequestException("El atributo telefono debe ser numerico y puede iniciar con +");
        }
    }
}
