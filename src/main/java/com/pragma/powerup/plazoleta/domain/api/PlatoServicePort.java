package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoServicePort {

    public Plato crearPlato(Plato platoNuevo);
    public Plato obtenerPlatoPorId(Long idPlato);
    public Plato modificarPlato(Plato platoModificado);

    public Plato activarDesactivarPlato(Plato plato);

}
