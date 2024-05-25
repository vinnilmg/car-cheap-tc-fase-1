package com.fiap.carcheap.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {
    private String tipoPagamento;
    private Long vendedorId;
    private String carroId;
    private Long clienteId;
}
