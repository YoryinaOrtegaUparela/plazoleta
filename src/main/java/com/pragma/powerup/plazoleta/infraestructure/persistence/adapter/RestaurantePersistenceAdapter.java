package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.RestauranteEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.RestauranteEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.RestauranteRepository;

import java.util.Optional;

public class RestaurantePersistenceAdapter implements RestaurantePersistencePort {

    private RestauranteEntityMapper restauranteEntityMapper;
    private RestauranteRepository restauranteRepository;

    public RestaurantePersistenceAdapter(RestauranteEntityMapper restauranteEntityMapper, RestauranteRepository restauranteRepository) {
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public Restaurante guardarRestaurante(Restaurante restauranteNuevo) {
        RestauranteEntity restauranteEntity = restauranteEntityMapper.restauranteToRestauranteEntity(restauranteNuevo);
        restauranteRepository.save(restauranteEntity);
        return restauranteNuevo;
    }

    @Override
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws PlazoletaNoDataFoundException {

        Optional<RestauranteEntity> restaurante = restauranteRepository.findById(idRestaurante);
        if (restaurante.isPresent()) {
            return true;
        }else{
            return false;
        }



    }
}
