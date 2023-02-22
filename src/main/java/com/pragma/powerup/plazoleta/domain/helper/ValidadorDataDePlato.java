package com.pragma.powerup.plazoleta.domain.helper;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.exception.ValidationRequestException;
import com.pragma.powerup.plazoleta.domain.model.Plato;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Realizar verificaciones de los atributos de los platos
 */
public class ValidadorDataDePlato {

    public static Plato validarDataParaCrearPlato(Plato plato) {
        validarDataObligatoria(plato);
        precioEsValido(plato.getPrecio());
        return plato;
    }

    public static Plato validarDataParaModificarPlato(Plato plato) {
        validarDataObligatoriaParaModificar(plato);
        precioEsValido(plato.getPrecio());
        return plato;
    }


    /**
     * Método para validar que los atributos obligatorios se encuentran
     *
     * @param plato
     */

    private static void validarDataObligatoria(Plato plato) {
        if (isNull(plato.getNombre())) {
            throw new InformacionNoEncontradaException("El atributo nombre es obligatorio");
        } else if (isNull(plato.getIdCategoria())) {
            throw new InformacionNoEncontradaException("El atributo idCategoria es obligatorio");
        } else if (isNull(plato.getDescripcion())) {
            throw new InformacionNoEncontradaException("El atributo descripcion es obligatorio");
        } else if (isNull(plato.getPrecio())) {
            throw new InformacionNoEncontradaException("El atributo precio es obligatorio");
        } else if (isNull(plato.getUrlImagen())) {
            throw new InformacionNoEncontradaException("El atributo urlImagen es obligatorio");
        } else if (isNull(plato.getIdRestaurante())) {
            throw new InformacionNoEncontradaException("El atributo idRestaurante es obligatorio");
        }
    }

    private static boolean isNull(Object campo) {
        if (campo == null) {
            return true;
        }
        return false;
    }

    /**
     * Método para validar que el atributo precio sea un entero positivo
     *
     * @param precio
     */
    private static void verificarPrecioEsEntero(String precio) {
        Pattern pattern = Pattern
                .compile("^\\d+$");
        Matcher mather = pattern.matcher(precio);
        if (!mather.find()) {
            throw new ValidationRequestException("El atributo precio debe ser un entero positivo");
        }
    }

    /**
     * Validar que el precio sea mayor que cero
     *
     * @param precio
     */
    private static void precioEsMayorQueCero(String precio) {
        Long precioLong = Long.parseLong(precio);
        if (precioLong <= 0) {
            throw new ValidationRequestException("El atributo precio debe ser mayor a 0");
        }
    }

    /**
     * Método para validar que el precio sea mayor que cero y sea entero positivo.
     *
     * @param precio
     */
    private static void precioEsValido(String precio) {
        verificarPrecioEsEntero(precio);
        precioEsMayorQueCero(precio);
    }

    private static void validarDataObligatoriaParaModificar(Plato plato) {
        if (isNull(plato.getId())) {
            throw new InformacionNoEncontradaException("El atributo idPlato es obligatorio");
        } else if (isNull(plato.getDescripcion())) {
            throw new InformacionNoEncontradaException("El atributo descripcion es obligatorio");
        } else if (isNull(plato.getPrecio())) {
            throw new InformacionNoEncontradaException("El atributo precio es obligatorio");
        }
    }

}
