package com.trabalho.presentation;

import com.trabalho.domain.Aluno;
import com.trabalho.domain.Plano;
import com.trabalho.domain.Treino;
import com.trabalho.repository.AlunoRepository;

import java.util.Scanner;
import java.util.List;

public class AlunoView {
    
    private final AlunoRepository repository = new AlunoRepository();
    private final Scanner scanner = new Scanner(System.in);

    // Método principal para iniciar a interface
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
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processarOpcao(int opcao) {
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
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // Lógica REVISADA para cadastrar Aluno com entrada de Plano e Treino
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

        // ----------------------------------------------------
        // ENTRADA PARA PLANO
        // ----------------------------------------------------
        System.out.println("\n--- CONFIGURAÇÃO DO PLANO ---");
        System.out.print("ID do Plano (Ex: 1): ");
        int idPlano;
        try {
            idPlano = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Aviso: ID inválido. Usando 1.");
            idPlano = 1;
        }

        System.out.print("Descrição do Plano (Ex: Gold, Basic): ");
        String descricaoPlano = scanner.nextLine();
        
        System.out.print("Valor Mensal (R$): ");
        double valorPlano;
        try {
            // Usa Double.parseDouble para garantir que o valor seja um número
            valorPlano = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Aviso: Valor inválido. Usando R$ 150.00.");
            valorPlano = 150.0;
        }
        
        // Cria o objeto Plano usando o construtor Plano(int id, String descricao, double valor)
        Plano planoSelecionado = new Plano(idPlano, descricaoPlano, valorPlano);
        
        // ----------------------------------------------------
        // CONFIGURAÇÃO DO TREINO
        // ----------------------------------------------------
        // Seu Treino usa um construtor vazio, então apenas o instanciamos.
        // A adição de Exercícios ficaria em um menu separado para não complicar o cadastro.
        System.out.println("\n--- CONFIGURAÇÃO DO TREINO ---");
        System.out.println("Treino criado. Você pode adicionar exercícios depois.");
        Treino treinoSelecionado = new Treino(); 
        
        // Cria o novo aluno (ID será 0 inicialmente)
        Aluno novoAluno = new Aluno(nome, cpf, telefone, matricula, planoSelecionado, treinoSelecionado);
        
        // Salva o aluno no Repositório (Map)
        repository.save(novoAluno);
        
        System.out.println("\n>>> Aluno " + nome + " cadastrado com sucesso! ID: " + novoAluno.getId());
        System.out.println(">>> Plano: " + planoSelecionado.getDescricao() + " | Valor: R$" + planoSelecionado.getValorMensal());
    }

    // Lógica para listar todos os Alunos
    private void listarAlunos() {
        System.out.println("\n--- LISTA DE TODOS OS ALUNOS ---");
        List<Aluno> alunos = repository.findAll();
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno a : alunos) {
            // Usa o método toString() do Aluno
            System.out.println(a);
        }
    }
    
    private void buscarAlunoPorId() {
        System.out.print("Digite o ID do aluno para buscar: ");
        int id = lerOpcao(); 
        
        Aluno aluno = repository.findById(id);
        
        if (aluno != null) {
            System.out.println("\n>>> Aluno Encontrado:");
            System.out.println(aluno);
        } else {
            System.out.println(">>> Erro: Aluno com ID " + id + " não encontrado.");
        }
    }

    private void atualizarAlunoPorId() {
        System.out.print("Digite o ID do aluno para atualizar: ");
        int id = lerOpcao();
        
        Aluno aluno = repository.findById(id);
        
        if (aluno == null) {
            System.out.println(">>> Erro: Aluno com ID " + id + " não encontrado.");
            return;
        }

        System.out.println(">>> Aluno Atual: " + aluno.getNome() + ". Digite o novo Telefone:");
        // Consome a linha pendente após ler o int
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
        
        boolean deletado = repository.deleteById(id);
        
        if (deletado) {
            System.out.println(">>> Sucesso: Aluno com ID " + id + " foi deletado.");
        } else {
            System.out.println(">>> Erro: Aluno com ID " + id + " não encontrado para exclusão.");
        }
    }
}
