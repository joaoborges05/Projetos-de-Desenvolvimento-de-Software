package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException; 

public class Exercicios {
    private String nomeexr;
    private String musculoAlvo;
    private int series;
    private int repeticoes;

    public Exercicios(String nomeexr, String musculoAlvo, int series, int repeticoes) {
    
        validarAtributos(nomeexr, musculoAlvo, series, repeticoes);
 
        this.nomeexr = nomeexr;
        this.musculoAlvo = musculoAlvo;
        this.series = series;
        this.repeticoes = repeticoes;
    }


    private void validarAtributos(String nome, String musculo, int series, int repeticoes) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O nome do exercício é obrigatório.");
        }
        if (musculo == null || musculo.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O músculo alvo é obrigatório.");
        }
        if (series <= 0) {
            throw new ValidacaoDeDominioException("O número de séries deve ser positivo.");
        }
        if (repeticoes <= 0) {
            throw new ValidacaoDeDominioException("O número de repetições deve ser positivo.");
        }
    }

    public String getNomeexr() {
        return nomeexr;
    }
    public void setNomeexr(String nomeexr) {
        if (nomeexr == null || nomeexr.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O nome do exercício é obrigatório.");
        }
        this.nomeexr = nomeexr;
    }

    public String getMusculoAlvo() {
        return musculoAlvo;
    }
    public void setMusculoAlvo(String musculoAlvo) {
        if (musculoAlvo == null || musculoAlvo.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O músculo alvo é obrigatório.");
        }
        this.musculoAlvo = musculoAlvo;
    }

    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        if (series <= 0) {
            throw new ValidacaoDeDominioException("O número de séries deve ser positivo.");
        }
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(int repeticoes) {
        if (repeticoes <= 0) {
            throw new ValidacaoDeDominioException("O número de repetições deve ser positivo.");
        }
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return nomeexr + " (" + musculoAlvo + ") - " + series + "x" + repeticoes;
    }
}