package com.fiap.carcheap.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PedidoRequest {
    private String tipoPagamento;
    private String vendedorId;
    private Long carroId;
    private Long clienteId;
}
