package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException; // <-- Importação da exceção de domínio
import java.util.Objects;

public class Aluno extends Pessoa {
    
    private int id;
    private String matricula;
    private Plano plano;
    private Treino treino;
    
    public Aluno(String nome, String cpf, String telefone, String matricula, Plano plano, Treino treino) {
        super(nome, cpf, telefone);
        validarPropriedades(matricula, plano); // Chama o método de validação
        this.matricula = matricula;
        this.plano = plano;
        this.treino = treino;
    }

    public Aluno(int id, String nome, String cpf, String telefone, String matricula, Plano plano, Treino treino) {
        super(nome, cpf, telefone);
        if (id <= 0) {
            throw new ValidacaoDeDominioException("ID do aluno deve ser um valor positivo.");
        }
        validarPropriedades(matricula, plano); // Chama o método de validação
        this.id = id;
        this.matricula = matricula;
        this.plano = plano;
        this.treino = treino;
    }

    private void validarPropriedades(String matricula, Plano plano) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A matrícula é obrigatória.");
        }
        if (plano == null) {
            throw new ValidacaoDeDominioException("O aluno deve ter um Plano associado.");
        }
    
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id <= 0) {
            throw new ValidacaoDeDominioException("ID do aluno deve ser um valor positivo.");
        }
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A matrícula é obrigatória.");
        }
        this.matricula = matricula;
    }

    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        if (plano == null) {
            throw new ValidacaoDeDominioException("O aluno deve ter um Plano associado.");
        }
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
    

    @Override
    public String toString() {
        return "ID: " + id + 
               " | Nome: " + getNome() + 
               " | Matrícula: " + matricula + 
               " | Plano: " + (plano != null ? plano.getDescricao() : "[Sem Plano]");
    }
}