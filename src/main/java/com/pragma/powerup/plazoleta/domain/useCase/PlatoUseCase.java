package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.helper.ValidadorDataDePlato;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;

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
    public Plato crearPlato(Plato plato) {

        ValidadorDataDePlato.validarDataParaCrearPlato(plato);

        //Validar que el restaurante donde se quiere agregar el plato exista
        boolean restauranteExiste = restauranteServicePort.validarSiExisteRestaurante(plato.getIdRestaurante());
        if (!restauranteExiste) {
            throw new InformacionNoEncontradaException("El idRestaurante " + plato.getIdRestaurante()
                    + " no existe.");
        }
        //Validar si la categoria donde se quiere agregar el plato exista
        boolean categoriaExiste = categoriaServicePort.validarSiCategoriaExiste(plato.getIdCategoria());
        if (!categoriaExiste) {
            throw new InformacionNoEncontradaException("El idCategoria " + plato.getIdCategoria() + " no existe.");
        }
        Plato platoCreado = platoPersistencePort.crearPlato(plato);
        return platoCreado;
    }

    @Override
    public Plato obtenerPlatoPorId(Long idPlato) throws InformacionNoEncontradaException {
        Plato platoEncontrado = platoPersistencePort.obtenerPlatoPorId(idPlato);
        return platoEncontrado;
    }

    @Override
    public Plato modificarPlato(Plato plato) {
        ValidadorDataDePlato.validarDataParaModificarPlato(plato);
        //Se verifica que el plato exista hy se recuperan todos los atributos para evitar error de referencia

        Plato platoModificado = obtenerPlatoPorId(plato.getId());
        platoModificado.setPrecio(plato.getPrecio());
        platoModificado.setDescripcion(plato.getDescripcion());
        platoPersistencePort.modificarPlato(platoModificado);
        return platoModificado;
    }

    @Override
    public Plato activarODesactivarPlato(Plato plato) {
        Plato platoActivoODesactivo = obtenerPlatoPorId(plato.getId());

           if (platoActivoODesactivo.isActivo()) {
                platoActivoODesactivo.setActivo(false);
            } else {
                platoActivoODesactivo.setActivo(true);
            }
        platoPersistencePort.modificarPlato(platoActivoODesactivo);
        return platoActivoODesactivo;
    }
}
