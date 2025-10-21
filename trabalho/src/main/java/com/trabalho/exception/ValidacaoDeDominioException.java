package com.trabalho.exception;

public class ValidacaoDeDominioException extends RuntimeException {

    public ValidacaoDeDominioException(String mensagem) {
        super(mensagem);
    }
    
    public ValidacaoDeDominioException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}