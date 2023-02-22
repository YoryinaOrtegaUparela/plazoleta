package com.pragma.powerup.plazoleta.application.mapper;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RestauranteMapper {

    public Restaurante convertirRestauranteDtoARestaurante(RestauranteRequestDto restauranteRequestDto);
    public RestauranteResponseDto convertirRestauranteARestauranteResponseDto(Restaurante restaurante);
}
