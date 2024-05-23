package com.fiap.carcheap.service.impl;

import com.fiap.carcheap.controller.mapper.PedidoResponseMapper;
import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.exception.CarroNotFoundException;
import com.fiap.carcheap.exception.PedidoNotFoundException;
import com.fiap.carcheap.exception.UserNotFoundException;
import com.fiap.carcheap.repository.PedidoRepository;
import com.fiap.carcheap.repository.UserRepository;
import com.fiap.carcheap.repository.entity.enums.ComissaoEnum;
import com.fiap.carcheap.repository.mapper.PedidoMapper;
import com.fiap.carcheap.service.CarroService;
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
    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private CarroService carroService;
    @Autowired
    private UserRepository userRepository;

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

        final var vendedor = userRepository.findById(request.getVendedorId());
        if (vendedor.isEmpty()) {
            throw new UserNotFoundException();
        }

        final var pedido = pedidoMapper.toPedido(request);
        pedido.setCarro(carro.get());
        pedido.setVendedor(vendedor.get());

        final var porcentagemComissao = ComissaoEnum.getComissaoByName(pedido.getCarro().getClassificacao()).getValor();
        pedido.setValorComissao(BigDecimal.valueOf((porcentagemComissao * pedido.getCarro().getVr_venda()) / 100));

        repository.save(pedido);
        return pedidoResponseMapper.toPedidoResponse(pedido);
    }
}
