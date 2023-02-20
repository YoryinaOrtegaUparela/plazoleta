package com.pragma.powerup.plazoleta.infraestructure.configuration;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.CategoriaPersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.useCase.CategoriaUseCase;
import com.pragma.powerup.plazoleta.domain.useCase.PlatoUseCase;
import com.pragma.powerup.plazoleta.domain.useCase.RestauranteUseCase;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.CategoriaPersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.PlatoPersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.RestaurantePersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.CategoriaEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PlatoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.RestauranteEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.CategoriaRepository;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.PlatoRepository;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    private final PlatoRepository platoRepository;
    private final PlatoEntityMapper platoEntityMapper;

    private final CategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    @Bean
    public RestaurantePersistencePort restaurantePersistencePort() {
        return new RestaurantePersistenceAdapter(restauranteEntityMapper, restauranteRepository);
    }

    @Bean
    public RestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistencePort());
    }

    @Bean
    public PlatoPersistencePort platoPersistencePort() {
        return new PlatoPersistenceAdapter(platoEntityMapper, platoRepository);
    }

    @Bean
    public PlatoServicePort platoServicePort() {
        return new PlatoUseCase(platoPersistencePort(),restauranteServicePort(), categoriaServicePort());
    }

    @Bean
    public CategoriaPersistencePort categoriaPersistencePort() {
        return new CategoriaPersistenceAdapter(categoriaRepository, categoriaEntityMapper);
    }

    @Bean
    public CategoriaServicePort categoriaServicePort() {
        return new CategoriaUseCase(categoriaPersistencePort());
    }
}
