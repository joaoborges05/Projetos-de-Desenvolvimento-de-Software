package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;

public class Relatorio {
    
    public void gerarRelatorioAluno(Aluno a) {
        
        if (a == null) {
            throw new ValidacaoDeDominioException("Não é possível gerar um relatório. O objeto Aluno é nulo.");
        }
        
        System.out.println("Relatório Aluno");
        System.out.println("Nome: " + a.getNome());
        System.out.println("CPF: " + a.getCpf());
        System.out.println("Telefone: " + a.getTelefone());
        
        Plano plano = a.getPlano();
        if (plano != null) {
            System.out.println("Plano ID: " + plano.getIdPlano());
            System.out.println("Valor Mensal: R$ " + plano.getValorMensal());
        }
        
        Treino treino = a.getTreino();
        if (treino != null) {
            System.out.println("Treino: ");
            treino.listarExercicios();
        }
    }
    
    public void gerarRelatorioPagamento(Pagamento p) {

        if (p == null) {
            throw new ValidacaoDeDominioException("Não é possível gerar um relatório. O objeto Pagamento é nulo.");
        }
    
        System.out.println("Relatório de Pagamento");
        System.out.println("ID: " + p.getIdPagamento());
        System.out.println("Valor: R$" + p.getValor());
        System.out.println("Data: " + p.getData());
        System.out.println("Status: " + p.getStatus());
    }

}