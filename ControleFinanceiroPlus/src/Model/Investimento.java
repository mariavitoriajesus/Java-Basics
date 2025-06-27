package Model;

import java.time.LocalDate;

public abstract class Investimento {
    protected String id;
    protected double valorInvestido;
    protected LocalDate dataAplicacao;
    protected LocalDate dataVencimento;
    protected Conta conta;

    public Investimento(double valorInvestido, LocalDate dataVencimento, Conta conta) {
        this.valorInvestido = valorInvestido;
        this.dataAplicacao = LocalDate.now();
        this.dataVencimento = dataVencimento;
        this.conta = conta;
    }

    public abstract double calcularRendimento();

    public String getId() {
        return id;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public Conta getConta() {
        return conta;
    }
}
