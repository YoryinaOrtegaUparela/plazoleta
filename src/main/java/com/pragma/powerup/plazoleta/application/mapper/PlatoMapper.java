package com.pragma.powerup.plazoleta.application.mapper;

import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PlatoMapper {

    public Plato platoRequestDtoToPlato(PlatoRequestDto platoRequestDto);
    public PlatoResponseDto platoToPlatoResponsetDto(Plato plato);
    public PlatoRequestDto platoToPlatoRequestDto(Plato plato);
}
