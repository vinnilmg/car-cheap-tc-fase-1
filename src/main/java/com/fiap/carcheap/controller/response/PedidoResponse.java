package com.fiap.carcheap.controller.response;

import com.fiap.carcheap.repository.entity.Carro;
import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private UserResponse vendedor;
    private Carro carro;
    private ClienteResponse cliente;
    private BigDecimal valorComissao;
    private TipoPagamentoEnum tipoPagamento;
    private StatusPedidoEnum statusPedido;
}
