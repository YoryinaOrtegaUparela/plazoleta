package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.model.Orden;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.spi.PedidoPersistencePort;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PedidoEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PedidoPlatoEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PedidoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.PedidoPlatoRepository;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.PedidoRepository;

import java.util.List;

public class PedidoPersistenceAdapter implements PedidoPersistencePort {

    private PedidoEntityMapper pedidoEntityMapper;
    private PedidoRepository pedidoRepository;
    private PedidoPlatoRepository pedidoPlatoRepository;

    public PedidoPersistenceAdapter(PedidoEntityMapper pedidoEntityMapper,
                                    PedidoRepository pedidoRepository, PedidoPlatoRepository pedidoPlatoRepository) {
        this.pedidoEntityMapper = pedidoEntityMapper;
        this.pedidoRepository = pedidoRepository;
        this.pedidoPlatoRepository = pedidoPlatoRepository;
    }

    @Override
    public Pedido realizarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoEntityMapper.convertirPedidoAPedidoEntity(pedido);
        PedidoEntity pedidoCreado = pedidoRepository.save(pedidoEntity);

        pedido.setId(pedidoCreado.getId());
        return pedido;
    }

    @Override
    public void generarPedido(Pedido pedido) {

        Long idPedido = pedido.getId();
        List<Orden> ordenList = pedido.getOrden();

        PedidoPlatoEntity pedidoPlatoEntity = new PedidoPlatoEntity();
        pedidoPlatoEntity.setIdPedido(idPedido);

        for (int i=0; i<ordenList.size(); i++) {

            Long cantidad = ordenList.get(i).getCantidad();
            Plato plato = ordenList.get(i).getPlato();

            pedidoPlatoEntity.setCantidad(cantidad);
            pedidoPlatoEntity.setIdPlato(plato.getId());
            pedidoPlatoRepository.save(pedidoPlatoEntity);
        }
    }
}
