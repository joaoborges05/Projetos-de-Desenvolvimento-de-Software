package com.trabalho.domain;

import com.trabalho.exception.PagamentoInvalidoException;

public class Pagamento {
    private int idPagamento;
    private double valor;
    private String data;
    private String status;

    public Pagamento (int idPagamento, double valor, String data, String status)throws PagamentoInvalidoException {
        if (valor <= 149) {
            throw new PagamentoInvalidoException("Valor do pagamento incorreto!!");
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
            public void setValor ( double valor){
                this.valor = valor;
            }

            public String getData () {
                return data;
            }
            public void setData (String data){
                this.data = data;
            }

            public String getStatus () {
                return status;
            }
            public void setStatus (String status){
                this.status = status;
            }

            public void exibirPagamento () {
                System.out.println("ID com.trabalho.domain.domain.Pagamento: " + idPagamento);
                System.out.println("Valor: " + valor);
                System.out.println("Data do pagamento: " + data);
                System.out.println("Status: " + status);
            }
        }
