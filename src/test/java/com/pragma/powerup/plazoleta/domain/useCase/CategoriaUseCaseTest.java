package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.spi.CategoriaPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CategoriaUseCaseTest {

    @InjectMocks
    private CategoriaUseCase categoriaUseCase;
    @Mock
    private CategoriaPersistencePort categoriaPersistencePort;

    @Test
    void debeValidarSiCategoriaExiste() {
        Mockito.when(categoriaPersistencePort.validarSiCategoriaExiste(Mockito.any())).thenReturn(true);

        Assertions.assertDoesNotThrow(() ->  categoriaUseCase.validarSiCategoriaExiste(2L));
    }

    @Test
    void debeValidarNoCategoriaExiste() {
        Mockito.when(categoriaPersistencePort.validarSiCategoriaExiste(Mockito.anyLong())).thenThrow(InformacionNoEncontradaException.class);

        Assertions.assertThrows(InformacionNoEncontradaException.class,
                () ->  categoriaUseCase.validarSiCategoriaExiste(2L));
    }

}