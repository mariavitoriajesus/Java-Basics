package Service;

import Model.Conta;
import Model.Pix;

public class TransacaoService {
    private BancoService bancoService;

    public TransacaoService(BancoService bancoService) {
        this.bancoService = bancoService;
    }
    public void transferirPix(String chaveOrigem, String chaveDestino, double valor){
        Pix origem = bancoService.buscarChavePix(chaveOrigem);
        Pix destino = bancoService.buscarChavePix(chaveDestino);

        origem.getConta().tranferir(destino.getConta(), valor);
    }
    public void depositar(String numeroConta, double valor){
        Conta conta = bancoService.buscarContaPorNumero(numeroConta);
        conta.depositar(valor);
    }
    public void sacar(String numeroConta, double valor){
        Conta conta = bancoService.buscarContaPorNumero(numeroConta);
        conta.sacar(valor);
    }
    public void tranferir(String contaOrigem, String contaDestino, double valor){
        Conta origem = bancoService.buscarContaPorNumero(contaDestino);
        Conta destino = bancoService.buscarContaPorNumero(contaDestino);
        origem.tranferir(destino, valor);
    }
}
