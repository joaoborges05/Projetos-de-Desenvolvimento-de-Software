import java.util.HashSet;
import java.util.Set;

public class Exe2 {
    public static void main(String[] args) {
        Set<String> nomes = new HashSet<>();
        nomes.add("Marlon");
        nomes.add("Francisco");
        nomes.add("João");
        nomes.add("Cássio");
        nomes.add("Hugo");
        System.out.println(nomes);
        System.out.println(nomes.contains("Cássio"));
        nomes.remove("Cássio");
        System.out.println(nomes);
    }
}
