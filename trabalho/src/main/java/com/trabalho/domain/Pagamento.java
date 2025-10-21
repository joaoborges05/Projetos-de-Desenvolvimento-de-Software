package com.trabalho.domain;

import com.trabalho.exception.PagamentoInvalidoException;

public class Pagamento {
    private int idPagamento;
    private double valor;
    private String data;
    private String status;

    public Pagamento (int idPagamento, double valor, String data, String status) throws PagamentoInvalidoException {
        
        if (valor <= 149) {
            throw new PagamentoInvalidoException("Valor do pagamento incorreto! Deve ser R$ 150.00 ou mais.");
        }
        if (data == null || data.trim().isEmpty()) {
            throw new PagamentoInvalidoException("A data do pagamento não pode ser vazia.");
        }
        if (status == null || status.trim().isEmpty()) {
            throw new PagamentoInvalidoException("O status do pagamento é obrigatório.");
        }

        this.idPagamento = idPagamento;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public int getIdPagamento () {
        return idPagamento;
    }
    public void setIdPagamento ( int idPagamento){
        this.idPagamento = idPagamento;
    }

    public double getValor () {
        return valor;
    }
    public void setValor ( double valor) throws PagamentoInvalidoException {
        // Validação no Setter
        if (valor <= 149) {
            throw new PagamentoInvalidoException("Valor do pagamento incorreto!! Deve ser R$ 150.00 ou mais.");
        }
        this.valor = valor;
    }

    public String getData () {
        return data;
    }
    public void setData (String data) throws PagamentoInvalidoException {
        if (data == null || data.trim().isEmpty()) {
            throw new PagamentoInvalidoException("A data do pagamento não pode ser vazia.");
        }
        this.data = data;
    }

    public String getStatus () {
        return status;
    }
    public void setStatus (String status) throws PagamentoInvalidoException {
        if (status == null || status.trim().isEmpty()) {
            throw new PagamentoInvalidoException("O status do pagamento é obrigatório.");
        }
        this.status = status;
    }

    public void exibirPagamento () {
        System.out.println("ID Pagamento: " + idPagamento);
        System.out.println("Valor: " + valor);
        System.out.println("Data do pagamento: " + data);
        System.out.println("Status: " + status);
    }
}
