package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.spi.CategoriaPersistencePort;

public class CategoriaUseCase implements CategoriaServicePort {

    private CategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(CategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }


    @Override
    public boolean validarCategoriaExiste(Long idCategoria) {
        return categoriaPersistencePort.validarSiCategoriaExiste(idCategoria);
    }
}
