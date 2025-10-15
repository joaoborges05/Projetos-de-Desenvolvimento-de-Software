package com.trabalho.domain;

import java.util.Date;

public class Agendamento {
    private int idAgendamento;
    private Date dataHora;
    private String atividade;
    private Aluno aluno;

    public Agendamento(int idAgendamento, Date dataHora, String atividade, Aluno aluno) {
        this.idAgendamento = idAgendamento;
        this.dataHora = dataHora;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getAtividade() {
        return atividade;
    }
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void exibirAgendamento() {
        System.out.println("ID com.trabalho.domain.domain.Agendamento" + idAgendamento);
        System.out.println("Data e Hora" + dataHora);
        System.out.println("Atividade" + atividade);
        System.out.println("com.trabalho.domain.domain.Aluno" + aluno.getNome());
    }
}
