package com.trabalho.domain;

public class Plano {
    private int idPlano;
    private String descricao;
    private double valorMensal;

    public Plano(int idPlano, String descricao, double valorMensal) {
        this.idPlano = idPlano;
        this.descricao = descricao;
        this.valorMensal = valorMensal;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
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
        this.valorMensal = valorMensal;
    }
}


