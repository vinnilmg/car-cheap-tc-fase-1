package com.fiap.carcheap.service.impl;

import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.controller.mapper.PedidoResponseMapper;
import com.fiap.carcheap.exception.PedidoNotFoundException;
import com.fiap.carcheap.repository.PedidoRepository;
import com.fiap.carcheap.repository.entity.Pedido;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import com.fiap.carcheap.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private PedidoResponseMapper pedidoResponseMapper;

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
    public void criaPedido() {
        final var pedido = new Pedido();
        pedido.setTipoPagamento(TipoPagamentoEnum.CREDITO);
        pedido.setVendedor("Vendedor maluco");
        pedido.setCarro("Corolla");
        pedido.setValorComissao(new BigDecimal("10000"));
        pedido.setCliente("Vini");
        repository.save(pedido);
    }
}
