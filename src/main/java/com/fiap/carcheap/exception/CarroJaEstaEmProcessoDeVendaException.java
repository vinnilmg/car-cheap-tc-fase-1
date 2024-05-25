package com.fiap.carcheap.exception;

public class CarroJaEstaEmProcessoDeVendaException extends RuntimeException {
    public CarroJaEstaEmProcessoDeVendaException() {
        super("Esse carro já está em um processo de venda.");
    }
}
