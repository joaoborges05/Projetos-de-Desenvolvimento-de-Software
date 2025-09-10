import java.util.ArrayList;
import java.util.List;

public class Treino {
    private List<Exercicios>exercicios;

    public Treino() {
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicios e) {
        if (e != null) {
            exercicios.add(e);
        }
    }
    public void listarExercicios(){
        if (exercicios.isEmpty()) {
            System.out.println("Nenhum exercício cadastrado nesse treino!");
        } else {
            System.out.println("Exercícios do treino: ");
            for (Exercicios e : exercicios){
                System.out.println ("Nome: " + e.getNomeexr());
                System.out.println("Músculo Alvo: " + e.getMusculoAlvo());
                System.out.println("Séries: " + e.getSeries());
                System.out.println("Repetições: " + e.getRepeticoes());
            }

        }

    }

}
