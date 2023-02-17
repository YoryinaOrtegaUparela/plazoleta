package com.pragma.powerup.plazoleta.infraestructure.persistence.repository;

import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity,Long> {

}
