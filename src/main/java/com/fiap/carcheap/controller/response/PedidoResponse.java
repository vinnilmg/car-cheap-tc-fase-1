package com.fiap.carcheap.controller.response;

import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private String vendedor;
    private String carro;
    private String cliente;
    private BigDecimal valorComissao;
    private TipoPagamentoEnum tipoPagamento;
}
