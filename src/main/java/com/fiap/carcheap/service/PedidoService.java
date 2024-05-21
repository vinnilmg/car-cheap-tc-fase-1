package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;

import java.util.List;

public interface PedidoService {
    List<PedidoResponse> buscaPedidos();

    PedidoResponse buscaPedido(Long id);

    PedidoResponse criaPedido(PedidoRequest request);
}
