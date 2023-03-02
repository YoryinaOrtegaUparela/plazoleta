package com.pragma.powerup.plazoleta.application.dto.response;

import com.pragma.powerup.plazoleta.domain.model.Orden;

import java.util.List;

public class PedidoResponseDto {

    private Long idRestaurante;
    private List<Orden> orden;
    private String estado;
    private Long idCliente;

    public PedidoResponseDto() {
    }


    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public List<Orden> getOrden() {
        return orden;
    }

    public void setOrden(List<Orden> orden) {
        this.orden = orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
