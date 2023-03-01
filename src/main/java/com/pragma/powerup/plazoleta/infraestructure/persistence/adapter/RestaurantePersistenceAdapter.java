package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.RestauranteEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.RestauranteEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.RestauranteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class RestaurantePersistenceAdapter implements RestaurantePersistencePort {

    private RestauranteEntityMapper restauranteEntityMapper;
    private RestauranteRepository restauranteRepository;

    public RestaurantePersistenceAdapter(RestauranteEntityMapper restauranteEntityMapper, RestauranteRepository restauranteRepository) {
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) {
        RestauranteEntity restauranteEntity = restauranteEntityMapper.convertirRestauranteARestauranteEntity(restaurante);
        restauranteRepository.save(restauranteEntity);
        return restaurante;
    }

    @Override
    public boolean validarSiRestauranteExiste(Long idRestaurante) throws InformacionNoEncontradaException {

        Optional<RestauranteEntity> restaurante = restauranteRepository.findById(idRestaurante);
        if (restaurante.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Restaurante> listarRestaurantes(RestauranteRequestDto restauranteRequestDto) {

        Pageable paginador = PageRequest.of(Integer.parseInt(restauranteRequestDto.getPagina()+""),
                Integer.parseInt(restauranteRequestDto.getNumeroRegistros()+""),
                Sort.by("nombre"));

        Page<RestauranteEntity> restauranteEntities =
                restauranteRepository.findAll(paginador);

        List<RestauranteEntity> listaRestaurantesEntity =restauranteEntities.getContent();

        List<Restaurante> listaRestaurantes =
                restauranteEntityMapper.convertirListaRestaurantesEntityAListaRestaurantes(listaRestaurantesEntity);
        return listaRestaurantes;
    }
}
