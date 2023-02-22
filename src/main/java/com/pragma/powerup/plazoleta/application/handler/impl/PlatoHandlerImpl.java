package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import com.pragma.powerup.plazoleta.application.mapper.PlatoMapper;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import org.springframework.stereotype.Service;

@Service
public class PlatoHandlerImpl implements PlatoHandler {

    private PlatoMapper platoMapper;
    private PlatoServicePort platoServicePort;


    public PlatoHandlerImpl(PlatoMapper platoMapper, PlatoServicePort platoServicePort) {
        this.platoMapper = platoMapper;
        this.platoServicePort = platoServicePort;
    }

    @Override
    public PlatoResponseDto crearPlato(PlatoRequestDto platoRequestDto) {
        //Mapeo plato requestDto a un plato
        Plato plato = platoMapper.platoRequestDtoToPlato(platoRequestDto);
        //llevo el plato a través del puerto de servicio
        Plato platoNuevo = platoServicePort.crearPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.platoToPlatoResponsetDto(platoNuevo);
        return platoResponseDto;
    }

    @Override
    public PlatoResponseDto modificarPlato(PlatoRequestDto platoRequestDto) {
        Plato plato = platoMapper.platoRequestDtoToPlato(platoRequestDto);
        Plato platoModificado = platoServicePort.modificarPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.platoToPlatoResponsetDto(platoModificado);
        return platoResponseDto;
    }

    @Override
    public PlatoResponseDto activarDesactivarPlato(PlatoRequestDto platoRequestDto) {
        Plato plato = platoMapper.platoRequestDtoToPlato(platoRequestDto);
        Plato platoActualizado = platoServicePort.activarDesactivarPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.platoToPlatoResponsetDto(platoActualizado);
        return platoResponseDto;
    }


}
