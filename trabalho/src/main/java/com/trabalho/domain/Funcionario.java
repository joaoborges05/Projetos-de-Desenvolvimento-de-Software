package com.trabalho.domain;

import com.trabalho.exception.ValidacaoDeDominioException; // Importa a exceção de domínio

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario) {
        super(nome, cpf, telefone);
        
        validarAtributos(cargo, salario);

        this.cargo = cargo;
        this.salario = salario;
    }

    private void validarAtributos(String cargo, double salario) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O cargo do funcionário é obrigatório.");
        }
        if (salario <= 0) {
            throw new ValidacaoDeDominioException("O salário deve ser um valor positivo.");
        }
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new ValidacaoDeDominioException("O cargo do funcionário é obrigatório.");
        }
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new ValidacaoDeDominioException("O salário deve ser um valor positivo.");
        }
        this.salario = salario;
    }

    public void exibirInformacoesFuncionario(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Salário: " + getSalario());
    }
}