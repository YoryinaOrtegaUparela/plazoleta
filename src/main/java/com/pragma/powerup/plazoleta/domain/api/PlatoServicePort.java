package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoServicePort {

    public void crearPlato(Plato platoNuevo);
    public Plato obtenerPlatoPorId(Long idPlato);
    public void modificarPlato(Plato platoModificado);

}
