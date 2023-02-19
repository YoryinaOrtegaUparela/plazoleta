package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.infraestructure.exception.NoDataFoundException;

public interface CategoriaPersistencePort {

    public boolean validarSiCategoriaExiste(Long idCategoria) throws NoDataFoundException;
}
