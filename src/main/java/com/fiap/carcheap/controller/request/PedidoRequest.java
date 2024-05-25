package com.fiap.carcheap.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {
    private String tipoPagamento;
    private String vendedorId;
    private String carroId;
    private String clienteId;
}
