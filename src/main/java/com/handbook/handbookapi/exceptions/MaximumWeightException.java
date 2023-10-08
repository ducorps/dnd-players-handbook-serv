package com.handbook.handbookapi.exceptions;

public class MaximumWeightException extends Exception {

    public MaximumWeightException() {
        super("O peso máximo do inventário não pode ser ultrapassado");
    }
}
