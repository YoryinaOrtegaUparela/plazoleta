package com.pragma.powerup.plazoleta.domain.useCase;

import com.pragma.powerup.plazoleta.domain.api.PedidoServicePort;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.spi.PedidoPersistencePort;

public class PedidoUseCase implements PedidoServicePort {

    private PedidoPersistencePort pedidoPersistencePort;

    public PedidoUseCase(PedidoPersistencePort pedidoPersistencePort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
    }

    @Override
    public Pedido realizarPedido(Pedido pedido) {
        Pedido pedido1 = pedidoPersistencePort.realizarPedido(pedido);
        pedidoPersistencePort.generarPedido(pedido);
        return pedido1;
    }
}
