package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoServicePort {

    public Plato crearPlato(Plato plato);
    public Plato obtenerPlatoPorId(Long idPlato);
    public Plato modificarPlato(Plato plato);
    public Plato activarODesactivarPlato(Plato plato);

}
