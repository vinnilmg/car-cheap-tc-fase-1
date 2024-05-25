package com.fiap.carcheap.service.impl;

import com.fiap.carcheap.controller.mapper.PedidoResponseMapper;
import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.exception.CarroNotFoundException;
import com.fiap.carcheap.exception.ClienteNotFoundException;
import com.fiap.carcheap.exception.PedidoNotFoundException;
import com.fiap.carcheap.exception.UserNotFoundException;
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
    public PedidoResponse buscaPedido(final Long id) {
        return getById(id)
                .map(pedidoResponseMapper::toPedidoResponse)
                .orElseThrow(PedidoNotFoundException::new);
    }

    public Optional<Pedido> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PedidoResponse criaPedido(final PedidoRequest request) {
        final var carro = carroService.findById(request.getCarroId());
        if (carro.isEmpty()) {
            throw new CarroNotFoundException();
        }

        final var vendedor = userService.getById(request.getVendedorId());
        if (vendedor.isEmpty()) {
            throw new UserNotFoundException();
        }

        final var cliente = clienteService.getById(request.getClienteId());
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


    @Override
    public PedidoResponse pagaPedido(final Long id) {
        return this.getById(id)
                .map(pedido -> {
                    pedido.setStatusPedido(StatusPedidoEnum.PAGO);
                    repository.save(pedido);
                    return pedidoResponseMapper.toPedidoResponse(pedido);
                })
                .orElseThrow(PedidoNotFoundException::new);
    }
}
