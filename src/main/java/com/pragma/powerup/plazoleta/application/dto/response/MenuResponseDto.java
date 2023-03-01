package com.pragma.powerup.plazoleta.application.dto.response;

import com.pragma.powerup.plazoleta.domain.model.SeccionMenu;

import java.util.List;

public class MenuResponseDto {

    private List<SeccionMenuResponseDto> seccionMenuResponseDtos;

    public MenuResponseDto() {
    }

    public List<SeccionMenuResponseDto> getSeccionMenuResponseDtos() {
        return seccionMenuResponseDtos;
    }

    public void setSeccionMenuResponseDtos(List<SeccionMenuResponseDto> seccionMenuResponseDtos) {
        this.seccionMenuResponseDtos = seccionMenuResponseDtos;
    }
}
