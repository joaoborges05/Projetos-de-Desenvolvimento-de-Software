package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException;
import java.util.Date;

public class Agendamento {
    private int idAgendamento;
    private Date dataHora;
    private String atividade;
    private Aluno aluno;

    public Agendamento(int idAgendamento, Date dataHora, String atividade, Aluno aluno) {
        if (dataHora == null || dataHora.before(new Date())) {
            throw new ValidacaoDeDominioException("A Data/Hora do agendamento é inválida ou retroativa.");
        }
        if (aluno == null) {
            throw new ValidacaoDeDominioException("O Agendamento deve estar associado a um Aluno.");
        }
        if (atividade == null || atividade.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A Atividade não pode ser vazia.");
        }
        
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
        if (dataHora == null || dataHora.before(new Date())) {
            throw new ValidacaoDeDominioException("A Data/Hora do agendamento é inválida ou retroativa.");
        }
        this.dataHora = dataHora;
    }

    public String getAtividade() {
        return atividade;
    }
    public void setAtividade(String atividade) {
        if (atividade == null || atividade.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("A Atividade não pode ser vazia.");
        }
        this.atividade = atividade;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new ValidacaoDeDominioException("O Agendamento deve ter um Aluno.");
        }
        this.aluno = aluno;
    }

    public void exibirAgendamento() {
        System.out.println("ID Agendamento: " + idAgendamento);
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("Atividade: " + atividade);
        
        if (aluno != null) {
            System.out.println("Aluno: " + aluno.getNome());
        } else {
            System.out.println("Aluno: [Aluno não definido]");
        }
    }
}