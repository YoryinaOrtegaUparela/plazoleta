package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;

public interface CategoriaPersistencePort {

    public boolean validarSiCategoriaExiste(Long idCategoria) throws PlazoletaNoDataFoundException;
}
