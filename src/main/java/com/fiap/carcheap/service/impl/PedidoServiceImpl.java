package com.fiap.carcheap.service.impl;

import com.fiap.carcheap.controller.mapper.PedidoResponseMapper;
import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.exception.*;
import com.fiap.carcheap.repository.PedidoRepository;
import com.fiap.carcheap.repository.entity.Pedido;
import com.fiap.carcheap.repository.entity.enums.ComissaoEnum;
import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;
import com.fiap.carcheap.repository.mapper.PedidoMapper;
import com.fiap.carcheap.service.CarroService;
import com.fiap.carcheap.service.ClienteService;
import com.fiap.carcheap.service.PedidoService;
import com.fiap.carcheap.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @Autowired
    private UserService userService;
    @Autowired
    private ClienteService clienteService;

    @Override
    public List<PedidoResponse> buscaPedidos() {
        return repository.findAll()
                .stream()
                .map(pedidoResponseMapper::toPedidoResponse)
                .toList();
    }

    @Override
    public PedidoResponse buscaPedido(final String id) {
        return getById(id)
                .map(pedidoResponseMapper::toPedidoResponse)
                .orElseThrow(PedidoNotFoundException::new);
    }

    public Optional<Pedido> getById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public PedidoResponse criaPedido(final PedidoRequest request) {
        final var carro = carroService.findById(request.getCarroId());
        if (carro.isEmpty()) {
            throw new CarroNotFoundException();
        }

        final var carroComVendaIniciada = repository.existsByCarroId(UUID.fromString(request.getCarroId()));
        if (carroComVendaIniciada) {
            throw new CarroJaEstaEmProcessoDeVendaException();
        }

        final var vendedor = userService.getById(request.getVendedorId());
        if (vendedor.isEmpty()) {
            throw new UserNotFoundException();
        }

        final var cliente = clienteService.getById(UUID.fromString(request.getClienteId()));
        if (cliente.isEmpty()) {
            throw new ClienteNotFoundException();
        }

        final var pedido = pedidoMapper.toPedido(request);
        pedido.setCarro(carro.get());
        pedido.setVendedor(vendedor.get());
        pedido.setCliente(cliente.get());

        final var porcentagemComissao = ComissaoEnum.getComissaoByName(pedido.getCarro().getClassificacao()).getValor();
        pedido.setValorComissao(Pedido.calculaComissao(porcentagemComissao, pedido.getCarro().getVr_venda()));

        repository.save(pedido);
        return pedidoResponseMapper.toPedidoResponse(pedido);
    }

    public PedidoResponse trocaStatusPedido(final String id, StatusPedidoEnum status) {
        return this.getById(id)
                .map(pedido -> {
                    pedido.setStatusPedido(status);
                    repository.save(pedido);
                    return pedidoResponseMapper.toPedidoResponse(pedido);
                })
                .orElseThrow(PedidoNotFoundException::new);
    }
}
