package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.MenuResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import com.pragma.powerup.plazoleta.application.mapper.RestauranteMapper;
import com.pragma.powerup.plazoleta.domain.api.PedidoServicePort;
import com.pragma.powerup.plazoleta.domain.api.RestauranteServicePort;
import com.pragma.powerup.plazoleta.domain.model.Pedido;
import com.pragma.powerup.plazoleta.domain.model.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteHandlerImpl implements RestauranteHandler {

    private RestauranteMapper restauranteMapper;
    private RestauranteServicePort restauranteServicePort;

    private PedidoServicePort pedidoServicePort;


    public RestauranteHandlerImpl(RestauranteMapper restauranteMapper,
                                  RestauranteServicePort restauranteServicePort, PedidoServicePort pedidoServicePort) {
        this.restauranteMapper = restauranteMapper;
        this.restauranteServicePort = restauranteServicePort;
        this.pedidoServicePort = pedidoServicePort;
    }

    @Override
    public RestauranteResponseDto crearRestaurante(RestauranteRequestDto restauranteRequestDto) {
        Restaurante restaurante = restauranteMapper.convertirRestauranteDtoARestaurante(restauranteRequestDto);
        Restaurante restauranteCreado = restauranteServicePort.crearRestaurante(restaurante);
        RestauranteResponseDto restauranteResponseDto =
                restauranteMapper.convertirRestauranteARestauranteResponseDto(restauranteCreado);
        return restauranteResponseDto;
    }

    @Override
    public ListaRestaurantesResponseDto listarRestaurantes(RestauranteRequestDto restauranteRequestDto) {

        //Listamos todos los restaurantes
        List<Restaurante> listaRestaurantes = restauranteServicePort.listarRestaurantes(restauranteRequestDto);

        //Mappeamos la lista de restaurantes a una lista de restauranteResponsedto
        List<RestauranteResponseDto> listaRestauranteResponseDtoList
                = restauranteMapper.convertirListaRestaurantesAListaRestaurantesResponseDto(listaRestaurantes);

        //Instanciamos una nueva ListaRestaurantesResponseDto y le colocamos el valor de la listaRestauranteResponseDtoList
        ListaRestaurantesResponseDto listaRestaurantesResponseDto = new ListaRestaurantesResponseDto();
        listaRestaurantesResponseDto.setListaDeRestaurantes(listaRestauranteResponseDtoList);

        return listaRestaurantesResponseDto;
    }

    @Override
    public PedidoResponseDto realizarPedido(PedidoRequestDto pedidoRequestDto) {

        Pedido pedido = restauranteMapper.convertirPedidoRequestDtoAPedido(pedidoRequestDto);

        Pedido pedidoRealizado = pedidoServicePort.realizarPedido(pedido);

        PedidoResponseDto pedidoResponseDto = restauranteMapper.convertirPedidoAPedidoResponseDto(pedidoRealizado);
        return pedidoResponseDto;
    }

}
