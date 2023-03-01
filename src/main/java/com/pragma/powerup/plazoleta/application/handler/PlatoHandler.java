package com.pragma.powerup.plazoleta.application.handler;

import com.pragma.powerup.plazoleta.application.dto.request.MenuRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.MenuResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;

public interface PlatoHandler {

    public PlatoResponseDto crearPlato(PlatoRequestDto platoRequestDto);
    public PlatoResponseDto modificarPlato(PlatoRequestDto platoRequestDto);
    public PlatoResponseDto activarODesactivarPlato(PlatoRequestDto platoRequestDto);
    public MenuResponseDto obtenerMenu(MenuRequestDto menuRequestDto);
}
