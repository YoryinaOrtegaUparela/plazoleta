package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PlatoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.PlatoRepository;

import java.util.Optional;

public class PlatoPersistenceAdapter implements PlatoPersistencePort {

    private PlatoEntityMapper platoEntityMapper;
    private PlatoRepository platoRepository;

    public PlatoPersistenceAdapter(PlatoEntityMapper platoEntityMapper, PlatoRepository platoRepository) {
        this.platoEntityMapper = platoEntityMapper;
        this.platoRepository = platoRepository;
    }

    @Override
    public Plato guardarPlato(Plato plato) {
        PlatoEntity platoEntity = platoEntityMapper.platoToPlatoEntityMapper(plato);
        PlatoEntity platoGuardado = platoRepository.save(platoEntity);

        plato.setId(platoGuardado.getId());
        return plato;
    }

    @Override
    public Plato buscarPlatoById(Long idPlato) {
        Optional<PlatoEntity> platoEntityModificar = platoRepository.findById(idPlato);
        Plato platoModificar = platoEntityMapper.platoEntityMapperToPlato(platoEntityModificar.get());
        return platoModificar;
    }

    @Override
    public void guardarCambiosPlato(Plato platoModificado) {
        PlatoEntity platoEntity = platoEntityMapper.platoToPlatoEntityMapper(platoModificado);
        platoRepository.save(platoEntity);

    }
}
