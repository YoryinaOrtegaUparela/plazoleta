package com.pragma.powerup.plazoleta.infraestructure.persistence.repository;

import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoConCategoria;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatoRepository extends JpaRepository<PlatoEntity, Long> {

    @Query(nativeQuery = true)
    List<PlatoConCategoria> platosConCategoria(Long idRestaurante, Pageable pageable);
}
