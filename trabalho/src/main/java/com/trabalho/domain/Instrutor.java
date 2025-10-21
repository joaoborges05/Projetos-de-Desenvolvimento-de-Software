package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException; 

public class Instrutor extends Pessoa implements Avaliacao { 
    private String especialidade;

    public Instrutor(String nome, String cpf, String telefone, String especialidade) {
        super(nome, cpf, telefone);
        
        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A especialidade do instrutor é obrigatória.");
        }
        
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A especialidade do instrutor é obrigatória.");
        }
        this.especialidade = especialidade;
    }

    @Override
    public void avaliarAluno() {
        System.out.println("Instrutor " + getNome() + " está avaliando o aluno");
    }
}