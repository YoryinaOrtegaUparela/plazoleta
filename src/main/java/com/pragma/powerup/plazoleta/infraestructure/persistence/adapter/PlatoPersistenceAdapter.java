package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
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
    public Plato crearPlato(Plato plato) {
        PlatoEntity platoEntity = platoEntityMapper.convertirPlatoAPlatoEntity(plato);
        PlatoEntity platoGuardado = platoRepository.save(platoEntity);

        plato.setId(platoGuardado.getId());
        return plato;
    }

    @Override
    public Plato obtenerPlatoPorId(Long idPlato) throws InformacionNoEncontradaException{
        Optional<PlatoEntity> platoEntityModificar = platoRepository.findById(idPlato);
        if(!platoEntityModificar.isPresent()){
            throw new InformacionNoEncontradaException("El plato suministrado no existe");
        }
        Plato platoModificar = platoEntityMapper.convertirPlatoEntityAPlato(platoEntityModificar.get());
        return platoModificar;
    }

    @Override
    public void modificarPlato(Plato platoModificado) {
        PlatoEntity platoEntity = platoEntityMapper.convertirPlatoAPlatoEntity(platoModificado);
        platoRepository.save(platoEntity);

    }
}
