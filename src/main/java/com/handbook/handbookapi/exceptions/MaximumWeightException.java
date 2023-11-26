package com.handbook.handbookapi.exceptions;

public class MaximumWeightException extends RuntimeException {

    public MaximumWeightException() {
        super("You cannot carry that weight in items");
    }
}
