package com.pragma.powerup.plazoleta.application.dto.response;

import java.util.List;

public class SeccionMenuResponseDto {

    private String categoria;
    private List<PlatoResponseDto> platoResponseDtoList;

    public SeccionMenuResponseDto() {
    }

    public SeccionMenuResponseDto(String categoria, List<PlatoResponseDto> platoResponseDtoList) {
        this.categoria = categoria;
        this.platoResponseDtoList = platoResponseDtoList;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<PlatoResponseDto> getPlatoResponseDtoList() {
        return platoResponseDtoList;
    }

    public void setPlatoResponseDtoList(List<PlatoResponseDto> platoResponseDtoList) {
        this.platoResponseDtoList = platoResponseDtoList;
    }
}
