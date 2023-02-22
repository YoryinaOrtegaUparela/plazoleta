package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoServicePort {

    public Plato crearPlato(Plato plato);
    public Plato obtenerPlatoPorId(Long idPlato)throws InformacionNoEncontradaException;
    public Plato modificarPlato(Plato plato);
    public Plato activarODesactivarPlato(Plato plato);

}
