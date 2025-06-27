package Model;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(Usuario titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0){
            throw new IllegalStateException("Valor de saque inválido");
        }
        if (valor > saldo){
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
        transacaos.add(new Transacao("SAQUE", -valor));
    }

    public void aplicarRendimento(){
        double rendimento = saldo * taxaRendimento;
        this.saldo += rendimento;
        transacaos.add(new Transacao("RENDIMENTO", rendimento));
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}
