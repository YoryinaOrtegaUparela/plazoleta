package com.pragma.powerup.plazoleta.application.handler;

import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;

public interface PlatoHandler {

    public PlatoResponseDto crearPlato(PlatoRequestDto platoNuevo);
    public PlatoResponseDto modificarPlato(PlatoRequestDto platoRequestDto);
    public void desactivarPlato(boolean desactivar);
    public void activarPlato(boolean activo);
}
