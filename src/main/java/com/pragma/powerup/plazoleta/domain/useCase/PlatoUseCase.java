package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;
import com.pragma.powerup.plazoleta.domain.helper.PlatoDataValidator;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;

public class PlatoUseCase implements PlatoServicePort {

    private PlatoPersistencePort platoPersistencePort;
    private RestauranteServicePort restauranteServicePort;
    private CategoriaServicePort categoriaServicePort;

    public PlatoUseCase(PlatoPersistencePort platoPersistencePort, RestauranteServicePort restauranteServicePort, CategoriaServicePort categoriaServicePort) {
        this.platoPersistencePort = platoPersistencePort;
        this.restauranteServicePort = restauranteServicePort;
        this.categoriaServicePort = categoriaServicePort;
    }

    @Override
    public Plato crearPlato(Plato platoNuevo) {
        //Validar que el restaurante donde se quiere agregar el plato exista
        restauranteServicePort.validarSiExisteRestaurante(platoNuevo.getIdRestaurante());
        //Validar si la categoria donde se quiere agregar el plato exista
        categoriaServicePort.validarCategoriaExiste(platoNuevo.getIdCategoria());

        Plato platoCreado = platoPersistencePort.guardarPlato(platoNuevo);
        return platoCreado;
    }

    @Override
    public Plato obtenerPlatoPorId(Long idPlato) {
        Plato platoEncontrado = platoPersistencePort.buscarPlatoById(idPlato);
        return platoEncontrado;
    }

    @Override
    public Plato modificarPlato(Plato platoModificado) {
        PlatoDataValidator.validarDataParaModificarPlato(platoModificado);
        //Se verifica que el plato exista hy se recuperan todos los atributos para evitar error de referencia
        Plato plato = obtenerPlatoPorId(platoModificado.getId());
        plato.setPrecio(platoModificado.getPrecio());
        plato.setDescripcion(platoModificado.getDescripcion());
        platoPersistencePort.guardarCambiosPlato(plato);
        return plato;
    }

    @Override
    public Plato activarDesactivarPlato(Plato platoActualizado) {
        Plato plato = obtenerPlatoPorId(platoActualizado.getId());

        if (platoActualizado.getIdRestaurante() == plato.getIdRestaurante()) {
            if (plato.isActivo()) {
                plato.setActivo(false);
            } else {
                plato.setActivo(true);
            }
        } else{
            throw new PlazoletaNoDataFoundException("El plato suministrado, no pertenece al restaurante indicado");
        }
        platoPersistencePort.guardarCambiosPlato(plato);
        return plato;
    }
}
