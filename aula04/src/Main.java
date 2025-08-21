import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//ARRAY
public class Main {
    public static void main(String[] args) {
        String[] nomes = new String[3];
        for(int i = 0; i < nomes.length; i++) {
            nomes[i] = "Nome";
            System.out.println(nomes[i]);
        }
        System.out.println(nomes);

        ArrayList<String> nomesList = new ArrayList<>();
        nomesList.add("Marlon");
        nomesList.add("Cidadão");
        nomesList.add("Outro nomes");
        System.out.println(nomesList);
        nomesList.remove("Marlon");
        System.out.println(nomesList);
        System.out.println(nomesList.get(0));
        System.out.println(nomesList.contains("Outro nomes"));
//SET
        System.out.println();
        System.out.println("Aqui começa Set");
        Set<String> coisas = new HashSet<String>();
        coisas.add("Maçã");
        coisas.add("Banana");
        coisas.add("Batata");
        coisas.add("Maçã");
        System.out.println(coisas.contains("Banana"));
//MAP
        System.out.println();
        System.out.println("Aqui começa Map");
        Map<Integer, String> alunos = new HashMap<>();
        alunos.put(12,"Cauã");
        alunos.put(15,"Natan");
        alunos.put(18,"João");
        System.out.println(alunos);
        System.out.println(alunos.get(15));
    }
}