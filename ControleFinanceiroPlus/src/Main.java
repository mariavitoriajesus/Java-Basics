import Model.ContaCorrente;
import Model.ContaPoupanca;
import Model.Pix;
import Model.Usuario;
import Service.BancoService;
import Service.InvestimentoService;
import Service.TransacaoService;

public class Main {
    public static void main(String[] args) {
        BancoService bancoService = new BancoService();
        TransacaoService transacaoService = new TransacaoService(bancoService);
        InvestimentoService investimentoService = new InvestimentoService(bancoService);

        // Criando usuários
        Usuario usuario1 = new Usuario("João Silva", "123.456.789-00", "joao@email.com");
        Usuario usuario2 = new Usuario("Maria Souza", "987.654.321-00", "maria@email.com");

        // Criando contas
        ContaCorrente ccJoao = bancoService.criarContaCorrente(usuario1, 1000);
        ContaPoupanca cpMaria = bancoService.criarContaPoupanca(usuario2, 0.005);

        // Cadastrando chaves PIX
        bancoService.cadastrarChavePix("joao@email.com", Pix.TipoChavePix.EMAIL, ccJoao);
        bancoService.cadastrarChavePix("987.654.321-00", Pix.TipoChavePix.CPF, cpMaria);

        // Realizando operações
        transacaoService.depositar(ccJoao.getNumeroConta(), 2000);
        transacaoService.transferirPix("joao@email.com", "987.654.321-00", 500);

        // Exibindo saldos
        System.out.println("Saldo João: R$ " + ccJoao.getSaldo());
        System.out.println("Saldo Maria: R$ " + cpMaria.getSaldo());

        // Exibindo histórico
        System.out.println("\nHistórico João:");
        ccJoao.getTransacaos().forEach(System.out::println);

        System.out.println("\nHistórico Maria:");
        cpMaria.getTransacaos().forEach(System.out::println);
    }
}

