package com.trabalho.exception;

public class AutorizacaoNegadaException extends RuntimeException {
     
    public AutorizacaoNegadaException(String mensagem) {
        super(mensagem);
    }

    public AutorizacaoNegadaException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}