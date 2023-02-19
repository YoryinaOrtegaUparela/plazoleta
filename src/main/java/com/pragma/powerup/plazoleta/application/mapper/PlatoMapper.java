package com.pragma.powerup.plazoleta.application.mapper;

import com.pragma.powerup.plazoleta.application.dto.PlatoRequestDto;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PlatoMapper {

    public Plato platoRequestDtoToPlato(PlatoRequestDto platoRequestDto);
    public PlatoRequestDto platoToPlatoRequestDto(Plato plato);
}
