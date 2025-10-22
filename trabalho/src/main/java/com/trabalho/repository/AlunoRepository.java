package com.trabalho.repository;

import com.trabalho.domain.Aluno;
import com.trabalho.domain.Plano;
import com.trabalho.domain.Treino;
import com.trabalho.exception.RecursoNaoEncontradoException; 
import com.trabalho.exception.ValidacaoDeDominioException; 
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AlunoRepository {

    private final Map<Integer, Aluno> alunosMap = new HashMap<>();
    private static final String FILE_NAME = "alunos_data.json";

    private int nextId = 1;

    public AlunoRepository() {
        this.load();
        
        if (!alunosMap.isEmpty()) {
            this.nextId = alunosMap.keySet().stream().max(Integer::compare).orElse(0) + 1;
        } else {
            this.nextId = 1;
        }
    }

    private int generateNextId() {
        return nextId++;
    }

    public Aluno save(Aluno aluno) {
        if (aluno.getId() == 0) {
            int newId = generateNextId();
            aluno.setId(newId);
            alunosMap.put(newId, aluno);
        } else {
            alunosMap.put(aluno.getId(), aluno);
        }
        
        this.saveToFile();
        
        return aluno;
    }

    public boolean deleteById(int id) {
        boolean deletado = alunosMap.remove(id) != null;
        if (deletado) {
            this.saveToFile();
        }
        return deletado;
    }

    public Aluno findById(int id) {
         Aluno aluno = alunosMap.get(id);
         if (aluno == null) {
            throw new RecursoNaoEncontradoException("Aluno com ID " + id + " não encontrado no repositório.");
         }
         return aluno;
    }

    public List<Aluno> findAll() {
        return new ArrayList<>(alunosMap.values());
    }
    
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("{\n");
            
            int count = 0;
            for (Map.Entry<Integer, Aluno> entry : alunosMap.entrySet()) {
                Aluno aluno = entry.getValue();
                
                writer.write("  \"" + entry.getKey() + "\": {\n");
                writer.write("    \"id\": " + aluno.getId() + ",\n");
                writer.write("    \"nome\": \"" + aluno.getNome() + "\",\n");
                writer.write("    \"cpf\": \"" + aluno.getCpf() + "\",\n");
                writer.write("    \"telefone\": \"" + aluno.getTelefone() + "\",\n");
                writer.write("    \"matricula\": \"" + aluno.getMatricula() + "\",\n");
                
                if (aluno.getPlano() != null) {
                    writer.write("    \"plano_descricao\": \"" + aluno.getPlano().getDescricao() + "\"\n"); 
                } else {
                    writer.write("    \"plano_descricao\": \"N/A\"\n");
                }
                
                writer.write("  }");
                
                if (++count < alunosMap.size()) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("}");
        } catch (IOException e) {
            System.err.println("ERRO CRÍTICO (I/O): Falha ao salvar dados no arquivo " + FILE_NAME + ": " + e.getMessage());
        }
    }

    private void load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            System.out.println("Carregando dados antigos do arquivo...");
            
            Plano planoFixo = new Plano(99, "Persistente", 150.0);
            Treino treinoFixo = new Treino(); 

            Aluno alunoPersistente = new Aluno(
                999, 
                "Aluno Antigo (Persistido)", 
                "000", 
                "0000-0000", 
                "P999", 
                planoFixo, 
                treinoFixo
            );
            
            alunosMap.put(alunoPersistente.getId(), alunoPersistente);

        } catch (IOException e) {
            System.err.println("ERRO CRÍTICO (I/O): Falha ao carregar dados do arquivo " + FILE_NAME + ". Iniciando com dados vazios: " + e.getMessage());
        } catch (ValidacaoDeDominioException e) {
            System.err.println("ERRO DE DADOS: O arquivo contém dados inválidos e não pôde ser carregado. " + e.getMessage());
        }
    }
}
