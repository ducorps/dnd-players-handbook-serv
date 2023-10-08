package com.handbook.handbookapi.exceptions;

public class PesoMaximoException extends Exception {

    public PesoMaximoException() {
        super("O peso máximo do inventário não pode ser ultrapassado");
    }
}
