package com.fiap.carcheap.exception;

public class CarroNotFoundException extends RuntimeException {
    public CarroNotFoundException() {
        super("Carro não existe.");
    }
}
