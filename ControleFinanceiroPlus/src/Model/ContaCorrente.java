package Model;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Usuario titular, double limiteChequeEspecial) {
        super(titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0){
            throw new IllegalStateException("Valor de saque inválido");
        }
        double saldoDisponivel = saldo + limiteChequeEspecial;
        if (valor > saldoDisponivel){
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
        transacaos.add(new Transacao("SAQUE", -valor));
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}
