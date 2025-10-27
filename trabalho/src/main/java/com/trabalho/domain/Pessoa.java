package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;
import java.util.regex.Pattern;

public abstract class Pessoa {

    private static final String NOME_REGEX = "^[\\p{L} .'-]+(?:\\s[\\p{L} .'-]+)*$";
    private static final String CPF_REGEX = "^\\d{11}$";
    private static final String TELEFONE_REGEX = "^\\d{11}$";

    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
    }

    private void validarObrigatoriedade(String valor, String nomeCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O(A) " + nomeCampo + " é obrigatório(a).");
        }
    }

    private void validarNomeFormato(String nome) {
        if (!Pattern.compile(NOME_REGEX).matcher(nome).matches()) {
            throw new ValidacaoDeDominioException("Nome inválido. Deve conter apenas letras, espaços e acentos.");
        }
    }

    private void validarCpfFormato(String cpf) {
        if (!Pattern.compile(CPF_REGEX).matcher(cpf).matches()) {
            throw new ValidacaoDeDominioException("CPF inválido. Deve ter exatamente 11 dígitos numéricos (sem formatação).");
        }
    }

    private void validarTelefoneFormato(String telefone) {
        if (!Pattern.compile(TELEFONE_REGEX).matcher(telefone).matches()) {
            throw new ValidacaoDeDominioException("Telefone inválido. Deve ter 11 dígitos numéricos (DDD com 2 + 9 dígitos, sem formatação).");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        validarObrigatoriedade(nome, "nome da pessoa");
        validarNomeFormato(nome);
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        validarObrigatoriedade(cpf, "CPF da pessoa");
        validarCpfFormato(cpf);
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        validarObrigatoriedade(telefone, "telefone da pessoa");
        validarTelefoneFormato(telefone);
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}
