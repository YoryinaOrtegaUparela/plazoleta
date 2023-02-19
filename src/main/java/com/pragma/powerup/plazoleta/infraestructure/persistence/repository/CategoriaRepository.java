package com.pragma.powerup.plazoleta.infraestructure.persistence.repository;

import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.CatergoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CatergoriaEntity, Long> {
}
