package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.exception.ValidationRequestException;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import com.pragma.powerup.plazoleta.domain.spi.RestaurantePersistencePort;
import com.pragma.powerup.plazoleta.domain.spi.UsuarioRemotePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RestauranteUseCaseTest {
    @Mock
    private RestaurantePersistencePort restaurantePersistencePort;
    @Mock
    private UsuarioRemotePort usuarioRemotePort;
    @InjectMocks
    private RestauranteUseCase restauranteUseCase;


    @Test
    void debeCrearRestaurante() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"300569874","logo");

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = new UsuarioRemoteResponseDto();
        usuarioRemoteResponseDto.setRol("PROPIETARIO");
        Mockito.when(usuarioRemotePort.validarRolUsuario(Mockito.any())).thenReturn(usuarioRemoteResponseDto);

        restauranteUseCase.crearRestaurante(restaurante);

        Mockito.verify(restaurantePersistencePort).crearRestaurante(restaurante);
    }

    @Test
    void debeCrearRestauranteConEstructuraTelefonoPuedeIniciarConMas() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"+300569874","logo");
        restauranteUseCase.crearRestaurante(restaurante);
        Mockito.verify(restaurantePersistencePort).crearRestaurante(restaurante);
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraNitIncorrecta() {

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = new UsuarioRemoteResponseDto();
        usuarioRemoteResponseDto.setRol("PROPIETARIO");
        Mockito.when(usuarioRemotePort.validarRolUsuario(Mockito.any())).thenReturn(usuarioRemoteResponseDto);

        Restaurante restaurante = new Restaurante(1L,"nombre1","800l62","callejon azul",2L,"300569874","logo");
        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraTelefonoMayorA13Caracteres() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"30056987401234","logo");

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = new UsuarioRemoteResponseDto();
        usuarioRemoteResponseDto.setRol("PROPIETARIO");
        Mockito.when(usuarioRemotePort.validarRolUsuario(Mockito.any())).thenReturn(usuarioRemoteResponseDto);

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestaurantePorEstructuraTelefonoSeaNumerico() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,"3005698740ee","logo");

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = new UsuarioRemoteResponseDto();
        usuarioRemoteResponseDto.setRol("PROPIETARIO");
        Mockito.when(usuarioRemotePort.validarRolUsuario(Mockito.any())).thenReturn(usuarioRemoteResponseDto);

        Assertions.assertThrows(ValidationRequestException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void noDebeCrearRestauranteSinUnCampoObligatorio() {
        Restaurante restaurante = new Restaurante(1L,"nombre1","800862","callejon azul",2L,null,"logo");

        UsuarioRemoteResponseDto usuarioRemoteResponseDto = new UsuarioRemoteResponseDto();
        usuarioRemoteResponseDto.setRol("PROPIETARIO");
        Mockito.when(usuarioRemotePort.validarRolUsuario(Mockito.any())).thenReturn(usuarioRemoteResponseDto);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        restauranteUseCase.crearRestaurante(restaurante));
    }

    @Test
    void validarSiExisteRestaurante() {
        Mockito.when(restaurantePersistencePort.validarSiRestauranteExiste(Mockito.any())).thenReturn(true);

        Assertions.assertDoesNotThrow(() ->  restauranteUseCase.validarSiExisteRestaurante(2L));
    }

    @Test
    void validarNoExisteRestaurante() {
        Mockito.when(restaurantePersistencePort.validarSiRestauranteExiste(Mockito.anyLong())).thenThrow(InformacionNoEncontradaException.class);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->
                        restauranteUseCase.validarSiExisteRestaurante(2L));
    }
}