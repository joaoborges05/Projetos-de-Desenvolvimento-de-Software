public class Teste {
    public static void main(String[] args) {
        Animal[] animais = new Animal[3];
        animais[0] = new Gato("Mingau");
        animais[1] = new Cachorro("Bolt");
        animais[2] = new Passaro("Papagaio");

        for (Animal animal : animais) {
            System.out.print(animal.nome + ": ");
            animal.emitirSom();
        }
    }
}
