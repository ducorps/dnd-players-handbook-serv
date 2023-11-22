package com.handbook.handbookapi.exceptions;

public class LoginSessionException extends Exception{

    public LoginSessionException() {
        super("É necessário estar logado para salvar personagens.");
    }
}
