package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoPersistencePort {

    public Plato crearPlato(Plato plato);
    public Plato obtenerPlatoPorId(Long idPlato)throws InformacionNoEncontradaException;
    public void modificarPlato(Plato platoModificado);
}
