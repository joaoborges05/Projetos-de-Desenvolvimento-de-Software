package com.trabalho.repository;

import com.trabalho.domain.Aluno;
import com.trabalho.domain.Plano; 
import com.trabalho.domain.Treino;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.io.*;

// Esta classe gerencia a coleção de Alunos usando um Map (HashMap)
public class AlunoRepository {

    // 1. O CORPO DA COLEÇÃO: O Map que armazena os alunos.
    // Key (Chave) = ID do aluno (Integer)
    // Value (Valor) = Objeto Aluno (Aluno)
    private final Map<Integer, Aluno> alunosMap = new HashMap<>();

    // Campo auxiliar para gerar IDs sequenciais automaticamente (simula um banco de dados)
    private int nextId = 1;

    // Método auxiliar para gerar o próximo ID
    private int generateNextId() {
        return nextId++;
    }

    // 2. Método CRUD: SALVAR / ATUALIZAR
    // Usa o Map para adicionar um novo aluno ou atualizar um existente.
    public Aluno save(Aluno aluno) {
        if (aluno.getId() == 0) {
            // É um novo Aluno: atribui um ID e coloca no Map
            int newId = generateNextId();
            aluno.setId(newId);
            alunosMap.put(newId, aluno);
            System.out.println("LOG: Aluno " + aluno.getNome() + " SALVO com ID: " + newId);
        } else {
            // Aluno já existe (tem ID): atualiza o objeto no Map (put sobrescreve a chave existente)
            alunosMap.put(aluno.getId(), aluno);
            System.out.println("LOG: Aluno " + aluno.getNome() + " (ID: " + aluno.getId() + ") ATUALIZADO.");
        }
        return aluno;
    }

    // 3. Método CRUD: BUSCAR POR ID (Busca ultra-rápida pela chave do Map)
    public Aluno findById(int id) {
        return alunosMap.get(id);
    }

    // 4. Método CRUD: BUSCAR TODOS
    // Retorna todos os valores (objetos Aluno) do Map em uma lista.
    public List<Aluno> findAll() {
        return new ArrayList<>(alunosMap.values());
    }

    // 5. Método CRUD: DELETAR
    public boolean deleteById(int id) {
        // remove(id) retorna o objeto removido (se existir)
        return alunosMap.remove(id) != null;
    }
}
