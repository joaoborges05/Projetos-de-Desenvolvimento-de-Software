package com.trabalho.domain;

public class Relatorio {
    public void gerarRelatorioAluno(Aluno a) {
        System.out.println("Relatório com.trabalho.domain.domain.Aluno");
        System.out.println("Nome: " + a.getNome());
        System.out.println("CPF: " + a.getCpf());
        System.out.println("Telefone: " + a.getTelefone());
        Plano plano = a.getPlano();
        if (plano != null) {
            System.out.println("com.trabalho.domain.domain.Plano: " + plano.getIdPlano());
            System.out.println("Valor Mensal: R$ " + plano.getValorMensal());

        }
        Treino treino = a.getTreino();
        if (treino != null) {
            System.out.println("com.trabalho.domain.domain.Treino: ");
            treino.listarExercicios();
        }
    }
    public void gerarRelatorioPagamento(Pagamento p) {
            System.out.println("Relatório de com.trabalho.domain.domain.Pagamento");
            System.out.println("ID: " + p.getIdPagamento());
            System.out.println("Valor: R$" + p.getValor());
            System.out.println("Data: " + p.getData());
            System.out.println("Status: " + p.getStatus());



    }

}
