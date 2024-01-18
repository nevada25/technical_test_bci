package com.technical.bci.technical_test_bci.exceptions;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException() {
        super("El correo ya está registrado");
    }
}