package com.trabalho.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    
    public RecursoNaoEncontradoException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}