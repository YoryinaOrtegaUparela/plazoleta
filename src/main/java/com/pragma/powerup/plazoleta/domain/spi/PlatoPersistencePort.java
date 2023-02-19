package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;

public interface PlatoPersistencePort {

    public void guardarPlato(Plato plato);
    public Plato buscarPlatoById(Long idPlato);
    public void guardarCambiosPlato(Plato platoModificado);
}
