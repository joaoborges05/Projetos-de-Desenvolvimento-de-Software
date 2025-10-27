package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Plano {

    private static final String PLANO_GOLD = "GOLD";
    private static final String PLANO_BASIC = "BASIC";

    private static final DecimalFormat FORMATADOR_BR;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        FORMATADOR_BR = new DecimalFormat("0.00", symbols);
    }

    private int idPlano;
    private String descricao;
    private double valorMensal;

    public Plano(int idPlano, String descricao, double valorMensal) {
        setIdPlano(idPlano);
        setDescricao(descricao);
        setValorMensal(valorMensal);
    }

    private void validarDescricaoFormato(String descricao) {
        String descricaoMaiuscula = descricao.trim().toUpperCase();

        if (!descricaoMaiuscula.equals(PLANO_GOLD) && !descricaoMaiuscula.equals(PLANO_BASIC)) {
            throw new ValidacaoDeDominioException("A descrição do Plano deve ser '" + PLANO_GOLD + "' ou '" + PLANO_BASIC + "'.");
        }
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A descrição do plano é obrigatória.");
        }

        validarDescricaoFormato(descricao);

        this.descricao = descricao.trim().toUpperCase();
    }

    public int getIdPlano() {
        return idPlano;
    }
    public void setIdPlano(int idPlano) {
        if (idPlano <= 0) {
            throw new ValidacaoDeDominioException("O ID do plano deve ser um valor positivo.");
        }
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
        String valorFormatado = FORMATADOR_BR.format(valorMensal);

        return "Plano [ID=" + idPlano + ", Descrição=" + descricao + ", Valor=R$" + valorFormatado + "]";
    }
}
