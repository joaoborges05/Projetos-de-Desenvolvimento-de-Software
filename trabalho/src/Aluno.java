public class Aluno extends Pessoa {
    private String matricula;
    private Plano plano;
    private Treino treino;
    public Aluno(String nome, String cpf, String telefone, String matricula, Plano plano, Treino treino) {
        super(nome, cpf, telefone);
        this.plano = plano;
        this.matricula = matricula;
        this.treino = treino;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Treino getTreino() {
        return treino;
    }
    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}
