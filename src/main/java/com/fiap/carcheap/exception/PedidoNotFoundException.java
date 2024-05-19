package com.fiap.carcheap.exception;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException() {
        super("Pedido não realizado.");
    }
}
