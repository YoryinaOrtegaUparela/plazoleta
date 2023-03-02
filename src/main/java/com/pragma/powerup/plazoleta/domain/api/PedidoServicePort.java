package com.pragma.powerup.plazoleta.domain.api;

import com.pragma.powerup.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.powerup.plazoleta.domain.model.Pedido;

public interface PedidoServicePort {

    public  Pedido realizarPedido(Pedido pedido);
}
