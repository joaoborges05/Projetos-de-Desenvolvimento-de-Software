package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa (String nome, String cpf, String telefone) {
     
        validarAtributos(nome, cpf, telefone);

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    private void validarAtributos(String nome, String cpf, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O nome da pessoa é obrigatório.");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O CPF da pessoa é obrigatório.");
        }
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O telefone da pessoa é obrigatório.");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O nome da pessoa é obrigatório.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O CPF da pessoa é obrigatório.");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O telefone da pessoa é obrigatório.");
        }
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}