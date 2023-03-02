package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.domain.model.Orden;
import com.pragma.powerup.plazoleta.domain.model.Pedido;

import java.util.List;

public interface PedidoPersistencePort {

    public Pedido realizarPedido(Pedido pedido);

    public void generarPedido(Pedido pedido);
}
