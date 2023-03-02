package com.pragma.powerup.plazoleta.infraestructure.persistence.mapper;

import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PedidoEntityMapper {
    PedidoEntity convertirPedidoAPedidoEntity(Pedido pedido);
}
