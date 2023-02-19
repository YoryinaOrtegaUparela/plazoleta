package com.pragma.powerup.plazoleta.infraestructure.persistence.repository;

import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<PlatoEntity, Long> {
}
