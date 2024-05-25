package com.fiap.carcheap.exception;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException() {
        super("Username já existe!.");
    }
}
