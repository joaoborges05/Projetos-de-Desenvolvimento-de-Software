public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;

    public ContaBancaria(int numero,String titular,double saldoInicial){
        this.numero = numero;
        this.saldo = saldoInicial;
        this.titular = titular;
    }
    public void depositar(double valor){
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }



    public void sacar(double valor){
        if (valor > 0 && saldo >= valor){
            saldo -= valor;
            System.out.println("Saque de R$" + valor + "realixado com sucesso");
        } else {
            System.out.println("Saque inválido");
        }

    }
    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

}
