package com.pragma.powerup.plazoleta.application.handler;

import com.pragma.powerup.plazoleta.application.dto.CambioPlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.PlatoRequestDto;
import com.pragma.powerup.plazoleta.domain.model.Plato;

public interface PlatoHandler {

    public void crearPlato(PlatoRequestDto platoNuevo);
    public void modificarPlato(CambioPlatoRequestDto platoModificar);
    public void desactivarPlato(boolean desactivar);
    public void activarPlato(boolean activo);
}
