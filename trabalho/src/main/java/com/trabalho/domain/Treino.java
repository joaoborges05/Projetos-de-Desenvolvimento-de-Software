package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Treino {
    private final List<Exercicios> exercicios;

    public Treino() {
        // Inicializa a lista no construtor para garantir que nunca seja nula
        this.exercicios = new ArrayList<>();
    }
    
    public void adicionarExercicio(Exercicios e) {
       
        if (e == null) {
            throw new ValidacaoDeDominioException("Não é possível adicionar um exercício nulo ao treino.");
        }
        exercicios.add(e);
    }
    
    public boolean removerExercicio(Exercicios e) {
        if (e == null) {
            
            throw new ValidacaoDeDominioException("Não é possível remover um exercício nulo do treino.");
        }
        return exercicios.remove(e);
    }

    public void listarExercicios(){
        if (exercicios.isEmpty()) {
            System.out.println("Nenhum exercício cadastrado nesse treino!");
        } else {
            System.out.println("--- Exercícios do Treino ---");
            for (Exercicios e : exercicios){
                System.out.println (e);
            }
        }
    }

    public List<Exercicios> getExercicios() {
        return Collections.unmodifiableList(exercicios);
    }
}