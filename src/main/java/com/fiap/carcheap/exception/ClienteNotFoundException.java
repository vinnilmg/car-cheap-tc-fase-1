package com.fiap.carcheap.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException() {
        super("Cliente não existe.");
    }
}
