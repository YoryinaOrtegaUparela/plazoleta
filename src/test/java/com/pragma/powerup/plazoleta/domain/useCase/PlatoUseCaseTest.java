package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.CategoriaServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.exception.ValidationRequestException;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PlatoUseCaseTest {

    @InjectMocks
    private PlatoUseCase platoUseCase;
    @Mock
    private PlatoPersistencePort platoPersistencePort;
    @Mock
    private RestauranteServicePort restauranteServicePort;
    @Mock
    private CategoriaServicePort categoriaServicePort;

    @Test
    void debeCrearPlato() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "sabrosa con tomate", "45200", 5L, "foto-foto");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        platoUseCase.crearPlato(plato);
        Mockito.verify(platoPersistencePort).crearPlato(plato);
    }

    @Test
    void noDebeCrearPlatoSinUnCampoObligatorio() {
        Plato plato = new Plato(1L, null, 2L, "hamburguesa la gloria", "2.3", 2L, "fotografia");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void noDebeCrearPlatoSiRestauranteNoExiste() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "sabrosa con tomate", "45200", 5L, "foto-foto");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(false);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void noDebeCrearPlatoSiCategoriaNoExiste() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "sabrosa con tomate", "45200", 5L, "foto-foto");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(false);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void noDebeCrearPlatoConPrecioIgualACero() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "00", 2L, "fotografia");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void noDebeCrearPlatoConPrecioMenorACero() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "-30000", 2L, "fotografia");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(Mockito.any())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void noDebeCrearPlatoConPrecioNoEntero() {
        Plato plato = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "2.3", 2L, "fotografia");
        Mockito.when(restauranteServicePort.validarSiExisteRestaurante(plato.getIdRestaurante())).thenReturn(true);
        Mockito.when(categoriaServicePort.validarSiCategoriaExiste(plato.getIdCategoria())).thenReturn(true);

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.crearPlato(plato));
    }

    @Test
    void debeObtenerPlatoPorId() {
        platoUseCase.obtenerPlatoPorId(6L);
        Mockito.verify(platoPersistencePort).obtenerPlatoPorId(Mockito.any());
    }

    @Test
    void noDebeObtenerPlatoPorId() {

        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenThrow(InformacionNoEncontradaException.class);
        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        platoUseCase.obtenerPlatoPorId(6L));
    }

    @Test
    void debeModificarPlato() {
        Plato platoPorId = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "20000", 2L, "fotografia");
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(platoPorId);

        Plato plato =new Plato();
        plato.setId(1l);
        plato.setPrecio("100");
        plato.setDescripcion("Nueva descripcion");

        platoUseCase.modificarPlato(plato);

        Mockito.verify(platoPersistencePort).modificarPlato(platoPorId);
    }

    @Test
    void noDebeModificarPlatoConPrecioNoEntero() {

        Plato platoPorId = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "20000", 2L, "fotografia");
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(platoPorId);

        Plato plato =new Plato();
        plato.setId(1l);
        plato.setPrecio("20.3000");
        plato.setDescripcion("Nueva descripcion");

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.modificarPlato(plato));
    }

    @Test
    void noDebeModificarPlatoConPrecioIgualACero() {
        Plato platoPorId = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "20000", 2L, "fotografia");
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(platoPorId);

        Plato plato =new Plato();
        plato.setId(1l);
        plato.setPrecio("00");
        plato.setDescripcion("Nueva descripcion");

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.modificarPlato(plato));
    }
    @Test
    void noDebeModificarPlatoConPrecioMenorACero() {
        Plato platoPorId = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "20000", 2L, "fotografia");
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(platoPorId);

        Plato plato =new Plato();
        plato.setId(1l);
        plato.setPrecio("-8500");
        plato.setDescripcion("Nueva descripcion");

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        platoUseCase.modificarPlato(plato));
    }

    @Test
    void debeActivarPlato() {
        //GIven un plato Activo
        Plato plato = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "8500", 2L, "fotografia");
        plato.setActivo(false);
        //WHen que hace cuando que cosa
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(plato);

        Plato platoActivo = platoUseCase.activarODesactivarPlato(plato);

        //El plato que
        Assertions.assertTrue(platoActivo.isActivo());

    }

    @Test
    void debeDesactivarPlato() {
        //GIven un plato Activo
        Plato plato = new Plato(1L, "hamburguesa", 2L, "hamburguesa la gloria", "8500", 2L, "fotografia");

        //WHen que hace cuando que cosa
        Mockito.when(platoPersistencePort.obtenerPlatoPorId(Mockito.anyLong())).thenReturn(plato);

        Plato platoInactivo = platoUseCase.activarODesactivarPlato(plato);

        //El plato que
        Assertions.assertFalse(platoInactivo.isActivo());
    }
}