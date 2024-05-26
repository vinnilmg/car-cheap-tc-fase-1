package com.fiap.carcheap.exception;

public class ClienteJaEstaEmProcessoDeVendaException extends RuntimeException {
    public ClienteJaEstaEmProcessoDeVendaException() {
        super("Esse cliente está em um processo de venda.");
    }
}
