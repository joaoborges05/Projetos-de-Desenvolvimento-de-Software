package com.trabalho.domain;

import java.util.Objects;

public class Aluno extends Pessoa {
    
    private int id;
    private String matricula;
    private Plano plano;
    private Treino treino;
    
    public Aluno(String nome, String cpf, String telefone, String matricula, Plano plano, Treino treino) {
        super(nome, cpf, telefone);
        this.matricula = matricula;
        this.plano = plano;
        this.treino = treino;
    }

    public Aluno(int id, String nome, String cpf, String telefone, String matricula, Plano plano, Treino treino) {
        super(nome, cpf, telefone);
        this.id = id;
        this.matricula = matricula;
        this.plano = plano;
        this.treino = treino;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Treino getTreino() {
        return treino;
    }
    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
