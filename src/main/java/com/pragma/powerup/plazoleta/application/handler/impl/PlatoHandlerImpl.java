package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.CambioPlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import com.pragma.powerup.plazoleta.application.mapper.PlatoMapper;
import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.CategoriaPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class PlatoHandlerImpl implements PlatoHandler {

    private PlatoMapper platoMapper;
    private PlatoServicePort platoServicePort;
    private RestauranteServicePort restauranteServicePort;
    private CategoriaServicePort categoriaServicePort;

    public PlatoHandlerImpl(PlatoMapper platoMapper, PlatoServicePort platoServicePort, RestauranteServicePort restauranteServicePort, CategoriaServicePort categoriaServicePort) {
        this.platoMapper = platoMapper;
        this.platoServicePort = platoServicePort;
        this.restauranteServicePort = restauranteServicePort;
        this.categoriaServicePort = categoriaServicePort;
    }

    @Override
    public void crearPlato(PlatoRequestDto platoNuevo) {
        restauranteServicePort.validarSiExisteRestaurante(platoNuevo.getIdRestaurante());
        categoriaServicePort.validarCategoriaExiste(platoNuevo.getIdCategoria());

        Plato plato = platoMapper.platoRequestDtoToPlato(platoNuevo);
        platoServicePort.crearPlato(plato);
    }

    @Override
    public void modificarPlato(CambioPlatoRequestDto platoModificar) {
        Plato plato = platoServicePort.obtenerPlatoPorId(platoModificar.getIdPlato());
        plato.setDescripcion(platoModificar.getDescripcion());
        plato.setPrecio(Long.parseLong(platoModificar.getPrecio()));
        platoServicePort.modificarPlato(plato);
    }

    @Override
    public void desactivarPlato(boolean desactivar) {

    }

    @Override
    public void activarPlato(boolean activo) {

    }
}
