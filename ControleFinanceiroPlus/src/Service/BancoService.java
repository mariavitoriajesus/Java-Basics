package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<Conta> contas;
    private List<Pix> chavesPix;

    public BancoService() {
        this.contas = new ArrayList<>();
        this.chavesPix = new ArrayList<>();
    }

    public ContaCorrente criarContaCorrente(Usuario titular, double limiteChequeEspecial){
        ContaCorrente cc = new ContaCorrente(titular,limiteChequeEspecial);
        contas.add(cc);
        return cc;
    }

    public ContaPoupanca criarContaPoupanca(Usuario titular, double taxaRendimento){
        ContaPoupanca cp = new ContaPoupanca(titular, taxaRendimento);
        contas.add(cp);
        return cp;
    }

    public Pix cadastrarChavePix(String chave, Pix.TipoChavePix tipo, Conta conta){
        Pix novaChave = new Pix(chave, tipo, conta);
        chavesPix.add(novaChave);
        return novaChave;
    }
    public Conta buscarContaPorNumero(String numeroConta){
        return contas.stream()
                .filter(c -> c.getNumeroConta().equals(numeroConta))
                .findFirst()
                .orElseThrow(() -> new IllegalAccessError("Conta não encontrada"));
    }

    public Pix buscarChavePix(String chave){
        return chavesPix.stream()
                .filter(p -> p.getChave().equals(chave))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Chave PIX não encontrada"));
    }
}
