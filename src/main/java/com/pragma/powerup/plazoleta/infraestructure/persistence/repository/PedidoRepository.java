package com.pragma.powerup.plazoleta.infraestructure.persistence.repository;

import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
