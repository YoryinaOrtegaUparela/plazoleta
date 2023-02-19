package com.pragma.powerup.plazoleta.infraestructure.persistence.mapper;

import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PlatoEntityMapper {

    public PlatoEntity platoToPlatoEntityMapper(Plato Plato);
    public Plato platoEntityMapperToPlato(PlatoEntity platoEntity);
}
