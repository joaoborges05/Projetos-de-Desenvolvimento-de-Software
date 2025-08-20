public class ContaCorrente extends ContaBancaria{
    private double limite;
    public ContaCorrente(int numero, String titular, double saldoInicial, double limite ) {
        super(numero, titular, saldoInicial);
        this.limite = limite;
    }
    private void atualizarSaldo(double novoSaldo) {
        try {
            java.lang.reflect.Field campoSaldo = ContaBancaria.class.getDeclaredField("saldo");
            campoSaldo.setAccessible(true);
            campoSaldo.set(this, novoSaldo);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar saldo.");
        }
    }
    @Override
    public void sacar(double valor) {
        if (valor > 0 && (getSaldo()+limite) >valor) {
            double novoSaldo = getSaldo() - valor;
            atualizarSaldo(novoSaldo);
            System.out.println("Saque de R$" + valor + " realizado com limite.");
        } else {
            System.out.println("Limite insuficiente ou valor inválido para saque.");
        }

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
