package com.handbook.handbookapi.exceptions;

public class GameRuleException extends RuntimeException {

    public GameRuleException(String message) {
        super(message);
    }

    public GameRuleException(String message, Throwable cause){
        super(message, cause);
    }
}
