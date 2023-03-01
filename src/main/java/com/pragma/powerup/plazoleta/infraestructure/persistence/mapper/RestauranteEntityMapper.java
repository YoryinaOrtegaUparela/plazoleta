package com.pragma.powerup.plazoleta.infraestructure.persistence.mapper;


import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.RestauranteEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RestauranteEntityMapper {

    /**
     * Método que convierte un restaurante en restaurante entidad.
     * @param restaurante
     * @return RestauranteEntity
     */

    public RestauranteEntity convertirRestauranteARestauranteEntity(Restaurante restaurante);


    public List<Restaurante> convertirListaRestaurantesEntityAListaRestaurantes(List<RestauranteEntity> listaRestaurantesEntity);
}
