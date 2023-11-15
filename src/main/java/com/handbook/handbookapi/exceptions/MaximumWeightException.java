package com.handbook.handbookapi.exceptions;

public class MaximumWeightException extends RuntimeException {

    public MaximumWeightException() {
        super("O peso máximo do inventário não pode ser ultrapassado");
    }
}
