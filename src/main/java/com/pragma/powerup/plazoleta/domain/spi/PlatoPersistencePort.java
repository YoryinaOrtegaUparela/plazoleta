package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.model.Categoria;
import com.pragma.powerup.plazoleta.domain.model.Menu;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.model.SeccionMenu;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;

import java.util.List;

public interface PlatoPersistencePort {

    public Plato crearPlato(Plato plato);
    public Plato obtenerPlatoPorId(Long idPlato)throws InformacionNoEncontradaException;
    public void modificarPlato(Plato platoModificado);
    List<SeccionMenu> obtenerSeccionMenu(Menu menu);

}
