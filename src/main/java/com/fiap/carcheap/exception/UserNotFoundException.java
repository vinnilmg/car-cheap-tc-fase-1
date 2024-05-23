package com.fiap.carcheap.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Vendedor não existe.");
    }
}
