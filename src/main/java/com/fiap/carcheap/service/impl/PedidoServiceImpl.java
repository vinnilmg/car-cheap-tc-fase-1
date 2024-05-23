package com.fiap.carcheap.service.impl;

import com.fiap.carcheap.controller.mapper.PedidoResponseMapper;
import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.exception.CarroNotFoundException;
import com.fiap.carcheap.exception.PedidoNotFoundException;
import com.fiap.carcheap.repository.PedidoRepository;
import com.fiap.carcheap.repository.mapper.PedidoMapper;
import com.fiap.carcheap.service.CarroService;
import com.fiap.carcheap.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private PedidoResponseMapper pedidoResponseMapper;
    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private CarroService carroService;

    @Override
    public List<PedidoResponse> buscaPedidos() {
        return repository.findAll()
                .stream()
                .map(pedidoResponseMapper::toPedidoResponse)
                .toList();
    }

    @Override
    public PedidoResponse buscaPedido(final Long id) {
        return repository.findById(id)
                .map(pedidoResponseMapper::toPedidoResponse)
                .orElseThrow(PedidoNotFoundException::new);
    }

    @Override
    public PedidoResponse criaPedido(final PedidoRequest request) {
        final var carro = carroService.findById(request.getCarroId());
        if (carro.isEmpty()) {
            throw new CarroNotFoundException();
        }

        // TODO: Precisa verificar se o cliente existe (aguardando metodos serem criados)

        final var pedido = pedidoMapper.toPedido(request, carro.get());
        repository.save(pedido);
        return pedidoResponseMapper.toPedidoResponse(pedido);
    }
}
