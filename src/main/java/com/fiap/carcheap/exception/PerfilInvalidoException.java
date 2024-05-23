package com.fiap.carcheap.exception;

public class PerfilInvalidoException extends RuntimeException {
    public PerfilInvalidoException() {
        super("Somente vendendores podem realizar as vendas");
    }
}
