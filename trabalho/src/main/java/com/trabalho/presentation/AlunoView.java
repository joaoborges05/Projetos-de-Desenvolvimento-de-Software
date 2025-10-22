package com.trabalho.presentation;

import com.trabalho.domain.Aluno;
import com.trabalho.domain.Plano;
import com.trabalho.domain.Treino;
import com.trabalho.repository.AlunoRepository;
import com.trabalho.exception.RecursoNaoEncontradoException; 
import com.trabalho.exception.ValidacaoDeDominioException; 
import java.util.Scanner;
import java.util.List;

public class AlunoView {
    
    private final AlunoRepository repository = new AlunoRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao(); 
            processarOpcao(opcao);
        } while (opcao != 0);
        
        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n--- GESTÃO DE ALUNOS ---");
        System.out.println("1. Cadastrar Novo Aluno");
        System.out.println("2. Listar Todos os Alunos");
        System.out.println("3. Buscar Aluno por ID");
        System.out.println("4. Atualizar Aluno por ID");
        System.out.println("5. Deletar Aluno por ID");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        String linha = scanner.nextLine();
        try {
            return Integer.parseInt(linha.trim());
        } catch (NumberFormatException e) {
            System.err.println("ERRO DE ENTRADA: Opção '" + linha + "' é inválida. Digite um número.");
            return -1;
        }
    }

    private void processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    buscarAlunoPorId();
                    break;
                case 4:
                    atualizarAlunoPorId();
                    break;
                case 5:
                    deletarAlunoPorId();
                    break;
                case 0:
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (ValidacaoDeDominioException e) {
            System.err.println("\n--- ERRO DE VALIDAÇÃO ---");
            System.err.println("Falha na Operação: " + e.getMessage());
        } catch (RecursoNaoEncontradoException e) {
            System.err.println("\n--- ERRO DE BUSCA ---");
            System.err.println("Status: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n--- ERRO INESPERADO (CRÍTICO) ---");
            System.err.println("Ocorreu um erro interno. Detalhe: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void cadastrarAluno() {
        System.out.println("\n--- CADASTRO DE NOVO ALUNO ---");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.println("\n--- CONFIGURAÇÃO DO PLANO ---");
        int idPlano;
        double valorPlano;
        
        try {
            System.out.print("ID do Plano (Ex: 1): ");
            idPlano = Integer.parseInt(scanner.nextLine());

            System.out.print("Descrição do Plano (Ex: Gold, Basic): ");
            String descricaoPlano = scanner.nextLine();
            
            System.out.print("Valor Mensal (R$): ");
            valorPlano = Double.parseDouble(scanner.nextLine());
            
            Plano planoSelecionado = new Plano(idPlano, descricaoPlano, valorPlano);
            Treino treinoSelecionado = new Treino(); 
            
            Aluno novoAluno = new Aluno(nome, cpf, telefone, matricula, planoSelecionado, treinoSelecionado);
            
            repository.save(novoAluno);
            
            System.out.println("\n>>> Aluno " + nome + " cadastrado com sucesso! ID: " + novoAluno.getId());
            System.out.println(">>> Plano: " + planoSelecionado.getDescricao() + " | Valor: R$" + planoSelecionado.getValorMensal());

        } catch (NumberFormatException e) {
            throw new ValidacaoDeDominioException("Erro de formato: ID ou Valor do Plano deve ser um número válido.");
        } 
    }

    private void listarAlunos() {
        System.out.println("\n--- LISTA DE TODOS OS ALUNOS ---");
        List<Aluno> alunos = repository.findAll();
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }
    
    private void buscarAlunoPorId() {
        System.out.print("Digite o ID do aluno para buscar: ");
        int id = lerOpcao(); 
        
        Aluno aluno = repository.findById(id);
        
        System.out.println("\n>>> Aluno Encontrado:");
        System.out.println(aluno);
    }

    private void atualizarAlunoPorId() {
        System.out.print("Digite o ID do aluno para atualizar: ");
        int id = lerOpcao();
        
        Aluno aluno = repository.findById(id);
        
        System.out.println(">>> Aluno Atual: " + aluno.getNome() + ". Digite o novo Telefone:");
        scanner.nextLine(); 
        System.out.print("Novo Telefone (Atual: " + aluno.getTelefone() + "): ");
        String novoTelefone = scanner.nextLine();

        aluno.setTelefone(novoTelefone); 
        repository.save(aluno); 
        
        System.out.println(">>> Aluno " + id + " atualizado com sucesso. Novo Telefone: " + aluno.getTelefone());
    }

    private void deletarAlunoPorId() {
        System.out.print("Digite o ID do aluno para DELETAR: ");
        int id = lerOpcao();
        
        repository.findById(id);
        
        boolean deletado = repository.deleteById(id);
        
        if (deletado) {
            System.out.println(">>> Sucesso: Aluno com ID " + id + " foi deletado.");
        } else {
             System.out.println("Aviso: Falha na exclusão, mas o aluno não foi encontrado (erro anterior).");
        }
    }
}
