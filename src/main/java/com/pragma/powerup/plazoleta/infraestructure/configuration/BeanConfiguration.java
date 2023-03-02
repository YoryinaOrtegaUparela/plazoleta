package com.pragma.powerup.plazoleta.infraestructure.configuration;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.PedidoServicePort;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.spi.*;
import com.pragma.powerup.plazoleta.domain.useCase.CategoriaUseCase;
import com.pragma.powerup.plazoleta.domain.useCase.PedidoUseCase;
import com.pragma.powerup.plazoleta.domain.useCase.PlatoUseCase;
import com.pragma.powerup.plazoleta.domain.useCase.RestauranteUseCase;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.CategoriaPersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.PedidoPersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.PlatoPersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.adapter.RestaurantePersistenceAdapter;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.CategoriaEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PedidoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PlatoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.RestauranteEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.*;
import com.pragma.powerup.plazoleta.infraestructure.remote.UsuarioRemoteAdapter;
import com.pragma.powerup.plazoleta.infraestructure.remote.feing.UsuarioRemoteClient;
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

    private final  UsuarioRemoteClient usuarioRemoteClient;

    private final PedidoRepository pedidoRepository;
    private final PedidoPlatoRepository pedidoPlatoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

    @Bean
    public PedidoPersistencePort pedidoPersistencePort() {
        return new PedidoPersistenceAdapter(pedidoEntityMapper, pedidoRepository, pedidoPlatoRepository);
    }

    @Bean
    public PedidoServicePort pedidoServicePort() {
        return new PedidoUseCase(pedidoPersistencePort());
    }


    @Bean
    public RestaurantePersistencePort restaurantePersistencePort() {
        return new RestaurantePersistenceAdapter(restauranteEntityMapper, restauranteRepository);
    }

    @Bean
    public RestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistencePort(),usuarioRemotePort());
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

    @Bean
    public UsuarioRemotePort usuarioRemotePort() {
        return new UsuarioRemoteAdapter(usuarioRemoteClient);
    }
}
