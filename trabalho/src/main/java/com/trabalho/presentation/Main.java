package com.trabalho.presentation;

import com.trabalho.domain.*;
import com.trabalho.exception.PagamentoInvalidoException;
import com.trabalho.exception.ValidacaoDeDominioException; // Import necessário
import com.trabalho.repository.AlunoRepository;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AlunoRepository repository = new AlunoRepository();

        // 1. CORREÇÃO: Mudar a descrição do Plano para "BASIC" ou "GOLD"
        Plano planoMensal = new Plano(1, "BASIC", 150.0); // Ou "GOLD"

        Treino treinoBasico = new Treino();

        try {
            treinoBasico.adicionarExercicio(new Exercicios("Supino", "Peito", 3, 12));
            treinoBasico.adicionarExercicio(new Exercicios("Tríceps corda", "Tríceps", 4, 10));

            // 2. CORREÇÃO: Mudar o Telefone para 11 dígitos numéricos sem formatação
            Aluno aluno1 = new Aluno("João", "12345678900", "41991112222", "101", planoMensal, treinoBasico);
            repository.save(aluno1);

            // 3. CORREÇÃO: Mudar o Telefone para 11 dígitos numéricos sem formatação
            Aluno aluno2 = new Aluno("Maria", "99988877766", "41993334444", "102", planoMensal, treinoBasico);
            repository.save(aluno2);

            // 4. CORREÇÃO: Mudar o Telefone para 11 dígitos numéricos sem formatação
            Instrutor instrutor = new Instrutor("Carlos", "98765432100", "41995556666", "Musculação");
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

        } catch (ValidacaoDeDominioException e) {
            System.err.println("\n--- ERRO CRÍTICO NA INICIALIZAÇÃO ---");
            System.err.println("O programa não pode iniciar devido a dados iniciais inválidos: " + e.getMessage());
            return;
        }

        new AlunoView().run();

    }
}
