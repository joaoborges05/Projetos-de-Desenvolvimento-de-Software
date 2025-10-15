package com.trabalho.domain;

public class Instrutor extends Pessoa implements Avaliacao {
    private String especialidade;

    public Instrutor(String nome, String cpf, String telefone, String especialidade) {
        super(nome, cpf, telefone);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void avaliarAluno() {
        System.out.println("com.trabalho.domain.domain.Instrutor " + getNome() + " está avaliando o aluno");

    }
}