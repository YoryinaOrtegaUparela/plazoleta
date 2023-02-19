package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;

public class PlatoUseCase implements PlatoServicePort {

    private PlatoServicePort platoServicePort;
    private PlatoPersistencePort platoPersistencePort;

    public PlatoUseCase(PlatoPersistencePort platoPersistencePort) {
        this.platoPersistencePort = platoPersistencePort;
    }

    @Override
    public void crearPlato(Plato platoNuevo) {
        platoPersistencePort.guardarPlato(platoNuevo);
    }

    @Override
    public Plato obtenerPlatoPorId(Long idPlato) {
        Plato platoEncontrado = platoPersistencePort.buscarPlatoById(idPlato);
        return platoEncontrado;
    }

    @Override
    public void modificarPlato(Plato platoModificado) {
        platoPersistencePort.guardarCambiosPlato(platoModificado);
    }
}
