package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.spi.CategoriaPersistencePort;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.CatergoriaEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.CategoriaEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.CategoriaRepository;

import java.util.Optional;

public class CategoriaPersistenceAdapter implements CategoriaPersistencePort {

    private CategoriaRepository categoriaRepository;
    private CategoriaEntityMapper categoriaEntityMapper;

    public CategoriaPersistenceAdapter(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaEntityMapper = categoriaEntityMapper;
    }

    @Override
    public boolean validarSiCategoriaExiste(Long idCategoria) throws InformacionNoEncontradaException {

        Optional<CatergoriaEntity> categoria = categoriaRepository.findById(idCategoria);
        if (categoria.isPresent()) {
            return true;
        }
        throw new InformacionNoEncontradaException("El idCategoria " + idCategoria + " no existe.");
    }
}
