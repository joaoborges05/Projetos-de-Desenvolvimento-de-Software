package com.trabalho.presentation;

import com.trabalho.domain.*;
import com.trabalho.exception.PagamentoInvalidoException;
import com.trabalho.repository.AlunoRepository;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws PagamentoInvalidoException {
        AlunoRepository repository = new AlunoRepository();

        Plano planoMensal = new Plano(1, "Mensal", 150.0);

        Treino treinoBasico = new Treino();
        treinoBasico.adicionarExercicio(new Exercicios("Supino", "Peito", 3, 12));
        treinoBasico.adicionarExercicio(new Exercicios("Tríceps corda", "Tríceps", 4, 10));

        Aluno aluno1 = new Aluno("João", "12345678900", "99999-1111", "001", planoMensal, treinoBasico);
        repository.save(aluno1);

        Aluno aluno2 = new Aluno("Maria", "99988877766", "99999-3333", "002", planoMensal, treinoBasico);
        repository.save(aluno2);

        Instrutor instrutor = new Instrutor("Carlos", "98765432100", "99999-2222", "Musculação");
        instrutor.avaliarAluno();

        Relatorio relatorio = new Relatorio();
        relatorio.gerarRelatorioAluno(aluno1);

        try {
            Pagamento pagamentoValido = new Pagamento(1, 150.0, "10/09/2025", "Pago");
            relatorio.gerarRelatorioPagamento(pagamentoValido);
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Lista de Alunos:");
        for (Aluno a : repository.findAll()) {
            System.out.println("- " + a.getMatricula() + " | " + a.getNome());
        }
    }
}