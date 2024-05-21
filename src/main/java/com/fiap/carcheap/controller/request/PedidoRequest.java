package com.fiap.carcheap.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {
    private String tipoPagamento;
    private String vendedor;
    private Long carroId;
    private String cliente;
}
