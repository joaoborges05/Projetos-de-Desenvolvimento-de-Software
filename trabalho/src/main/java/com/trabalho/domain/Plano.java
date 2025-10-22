package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;

public class Plano {
    private int idPlano;
    private String descricao;
    private double valorMensal;

    public Plano(int idPlano, String descricao, double valorMensal) {
   
        validarAtributos(descricao, valorMensal);
        
        this.idPlano = idPlano;
        this.descricao = descricao;
        this.valorMensal = valorMensal;
    }


    private void validarAtributos(String descricao, double valorMensal) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A descrição do plano é obrigatória.");
        }
        if (valorMensal <= 0) {
            throw new ValidacaoDeDominioException("O valor mensal do plano deve ser maior que zero.");
        }
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A descrição do plano é obrigatória.");
        }
        this.descricao = descricao;
    }

    public int getIdPlano() {
        return idPlano;
    }
    public void setIdPlano(int idPlano) {
    
        this.idPlano = idPlano;
    }

    public double getValorMensal() {
        return valorMensal;
    }
    public void setValorMensal(double valorMensal) {
        if (valorMensal <= 0) {
            throw new ValidacaoDeDominioException("O valor mensal do plano deve ser maior que zero.");
        }
        this.valorMensal = valorMensal;
    }
    
    @Override
    public String toString() {
        return "Plano [ID=" + idPlano + ", Descrição=" + descricao + ", Valor=R$" + valorMensal + "]";
    }
}