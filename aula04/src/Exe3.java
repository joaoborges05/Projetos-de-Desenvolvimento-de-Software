import java.util.HashMap;
import java.util.Map;

public class Exe3 {
    public static void main(String[] args) {
        Map<String, Integer> prodprec = new HashMap<>();
        prodprec.put("Fini", 11);
        prodprec.put("Arroz", 15);
        prodprec.put("Pilha", 3);
        prodprec.put("Mentos", 5);
        prodprec.put("Picanha",100);

        for (Map.Entry<String, Integer> entrada: prodprec.entrySet()){
            if (entrada.getValue()>10){
                System.out.println(entrada.getKey());
            }
        }
    }
}
