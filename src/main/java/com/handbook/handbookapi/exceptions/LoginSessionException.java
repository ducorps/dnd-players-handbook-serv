package com.handbook.handbookapi.exceptions;

public class LoginSessionException extends Exception{

    public LoginSessionException() {
        super("You need to be logged to save characters.");
    }
}
