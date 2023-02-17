package com.pragma.powerup.plazoleta.infraestructure.configuration;

import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.useCase.RestauranteUseCase;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.RestaurantePersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.RestauranteEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    @Bean
    public RestaurantePersistencePort restaurantePersistencePort() {
        return new RestaurantePersistenceAdapter(restauranteEntityMapper, restauranteRepository);
    }

    @Bean
    public RestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistencePort());
    }
}
