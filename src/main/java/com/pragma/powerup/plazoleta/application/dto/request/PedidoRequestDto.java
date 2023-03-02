package com.pragma.powerup.plazoleta.application.dto.request;

import java.util.List;

public class PedidoRequestDto {

    private Long idCliente;
    private Long idRestaurante;
    private List<OrdenDto> orden;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public List<OrdenDto> getOrden() {
        return orden;
    }

    public void setOrden(List<OrdenDto> orden) {
        this.orden = orden;
    }
}
