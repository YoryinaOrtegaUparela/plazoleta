package com.pragma.powerup.plazoleta.infraestructure.persistence.mapper;

import com.pragma.powerup.plazoleta.domain.model.Categoria;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.CatergoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoriaEntityMapper {

    public CatergoriaEntity convertirCategoriaACategoriaEntity(Categoria categoria);
}
