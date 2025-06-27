package Model;

import Util.GeradorNumeroConta;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String numeroConta;
    protected double saldo;
    protected Usuario titular;
    protected List<Transacao> transacaos;

    public Conta(Usuario titular) {
        this.numeroConta = GeradorNumeroConta.gerar();
        this.saldo = 0;
        this.titular = titular;
        this.transacaos = new ArrayList<>();
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalStateException("Valor de depósito inválido");
        }
        this.saldo += valor;
        transacaos.add(new Transacao("DEPÓSITAR", valor));
    }

    public abstract void sacar(double valor);

    public void tranferir(Conta destino, double valor){
        if (valor <= 0) {
            throw new IllegalStateException("Valor de tranferência inválido");
        }
        this.sacar(valor);
        destino.depositar(valor);
        transacaos.add(new Transacao("TRANFERÊNCIA PARA " + destino.numeroConta, -valor));
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public List<Transacao> getTransacaos() {
        return new ArrayList<>(transacaos);
    }

    public void pix(Pix chaveDestino, double valor){

    }
}
