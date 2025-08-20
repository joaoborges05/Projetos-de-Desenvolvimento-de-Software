public class Main {
    public static void main(String[] args) {
        // Criando uma conta bancária comum
        ContaBancaria conta1 = new ContaBancaria(123, "João", 500.0);
        System.out.println("ContaBancaria - Titular: " + conta1.getTitular());
        conta1.depositar(200.0);
        conta1.sacar(300.0);
        System.out.println("Saldo final: R$" + conta1.getSaldo());
        System.out.println();

        // Criando uma conta corrente com limite
        ContaCorrente conta2 = new ContaCorrente(456, "Maria", 300.0, 200.0);
        System.out.println("ContaCorrente - Titular: " + conta2.getTitular());
        conta2.depositar(100.0);
        conta2.sacar(100.0);
        System.out.println("Saldo final com limite: R$" + conta2.getSaldo());
    }
}
