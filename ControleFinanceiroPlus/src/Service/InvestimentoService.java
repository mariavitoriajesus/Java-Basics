package Service;

import Model.Conta;
import Model.Investimento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoService {
    private List<Investimento> investimentos;
    private BancoService bancoService;

    public InvestimentoService(BancoService bancoService) {
        this.investimentos = new ArrayList<>();
        this.bancoService = bancoService;
    }

    public void aplicarInvestimentos(String idInvestimento){
        Investimento investimento = investimentos.stream()
                .filter(i -> i.getId().equals(idInvestimento))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Investimento não encontrado"));
        if (LocalDate.now().isBefore(investimento.getDataVencimento())) {
            throw new IllegalStateException("Investimento ainda não venceu");
        }

        double valorResgate = investimento.getValorInvestido() + investimento.calcularRendimento();
        investimento.getConta().depositar(valorResgate);
        investimentos.remove(investimento);
    }

    public List<Investimento> listarInvestimentosPorConta(String numeroConta) {
        Conta conta = bancoService.buscarContaPorNumero(numeroConta);
        return investimentos.stream()
                .filter(i -> i.getConta().equals(conta))
                .toList();
    }
}
