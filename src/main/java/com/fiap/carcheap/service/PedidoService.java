package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;

import java.util.List;

public interface PedidoService {
    List<PedidoResponse> buscaPedidos();

    PedidoResponse buscaPedido(String id);

    PedidoResponse criaPedido(PedidoRequest request);

    PedidoResponse trocaStatusPedido(String id, StatusPedidoEnum status);
}
