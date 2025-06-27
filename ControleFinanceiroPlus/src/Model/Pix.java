package Model;

public class Pix {
    private String chave;
    private TipoChavePix tipo;
    private Conta conta;

    public Pix(String chave, TipoChavePix tipo, Conta conta) {
        this.chave = chave;
        this.tipo = tipo;
        this.conta = conta;
    }

    public String getChave() {
        return chave;
    }

    public TipoChavePix getTipo() {
        return tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public enum TipoChavePix {
        CPF, EMAIL, TELEFONE, ALEATORIA
    }
}
