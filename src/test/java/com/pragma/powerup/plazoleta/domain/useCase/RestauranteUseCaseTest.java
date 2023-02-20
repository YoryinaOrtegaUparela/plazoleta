package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.exception.PlazoletaNoDataFoundException;
import com.pragma.powerup.plazoleta.domain.exception.PlazoletaValidationRequestException;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
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
class RestauranteUseCaseTest {
    @Mock
    private RestaurantePersistencePort restaurantePersistencePort;
    @InjectMocks
    private RestauranteUseCase restauranteUseCase;

    @Test
    void debeCrearRestaurante() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"300569874","logo");
        restauranteUseCase.crearRestaurante(restaurante);
        Mockito.verify(restaurantePersistencePort).guardarRestaurante(restaurante);
    }

    @Test
    void debeCrearRestauranteConEstructuraTelefonoPuedeIniciarConMas() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"+300569874","logo");
        restauranteUseCase.crearRestaurante(restaurante);
        Mockito.verify(restaurantePersistencePort).guardarRestaurante(restaurante);
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraNitIncorrecta() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800l62","callejon azul",2L,"300569874","logo");
        Assertions.assertThrows(PlazoletaValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraTelefonoMayorA13Caracteres() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"30056987401234","logo");
        Assertions.assertThrows(PlazoletaValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraTelefonoSeaNumerico() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"3005698740ee","logo");
        Assertions.assertThrows(PlazoletaValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestauranteSinUnCampoObligatorio() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,null,"logo");
        Assertions.assertThrows(PlazoletaNoDataFoundException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void validarSiExisteRestaurante() {
        restauranteUseCase.validarSiExisteRestaurante(2L);
        Mockito.verify(restaurantePersistencePort).validarSiRestauranteExiste(Mockito.anyLong());
    }

    @Test
    void validarNoExisteRestaurante() {
        Mockito.when(restaurantePersistencePort.validarSiRestauranteExiste(Mockito.anyLong())).thenThrow(PlazoletaNoDataFoundException.class);

        Assertions.assertThrows(PlazoletaNoDataFoundException.class,
                () ->
                        restauranteUseCase.validarSiExisteRestaurante(2L));
    }
}