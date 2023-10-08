package com.handbook.handbookapi.exceptions;

public class SessaoLoginException extends Exception{

    public SessaoLoginException() {
        super("É necessário estar logado para salvar personagens.");
    }
}
