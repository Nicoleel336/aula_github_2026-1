import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaService {
    private final List<Conta> contas;
    private final ClienteService clienteService;
    private final Scanner scanner;

    public ContaService(ClienteService clienteService) {
        this.contas = new ArrayList<>();
        this.clienteService = clienteService;
        this.scanner = new Scanner(System.in);
    }

    public void abrirConta() {
        System.out.println("\n=== Abertura de Conta ===");

        if (clienteService.getClientes().isEmpty()) {
            System.out.println("Nao e possivel abrir conta sem clientes cadastrados.");
            return;
        }

        String cpf = lerCampoObrigatorio("CPF do cliente");
        Cliente cliente = clienteService.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }

        if (clienteJaPossuiConta(cliente.getCpf())) {
            System.out.println("Este cliente ja possui uma conta aberta.");
            return;
        }

        String numeroConta = lerCampoObrigatorio("Numero da conta");
        if (contaJaExiste(numeroConta)) {
            System.out.println("Ja existe uma conta cadastrada com este numero.");
            return;
        }

        String tipoConta = selecionarTipoConta();
        double saldoInicial = lerSaldoInicial();

        Conta conta = new Conta(numeroConta, tipoConta, saldoInicial, cliente);
        contas.add(conta);

        System.out.println("\nConta aberta com sucesso!");
        System.out.println(conta);
    }

    private String lerCampoObrigatorio(String nomeCampo) {
        String valor;

        do {
            System.out.print(nomeCampo + ": ");
            valor = scanner.nextLine().trim();

            if (valor.isEmpty()) {
                System.out.println("O campo " + nomeCampo + " e obrigatorio.");
            }
        } while (valor.isEmpty());

        return valor;
    }

    private double lerSaldoInicial() {
        while (true) {
            String valor = lerCampoObrigatorio("Saldo inicial");

            try {
                double saldo = Double.parseDouble(valor.replace(',', '.'));

                if (saldo < 0) {
                    System.out.println("O saldo inicial nao pode ser negativo.");
                    continue;
                }

                return saldo;
            } catch (NumberFormatException e) {
                System.out.println("Informe um valor numerico valido para o saldo inicial.");
            }
        }
    }

    private String selecionarTipoConta() {
        Menu menuTipoConta = new Menu("Tipo da Conta", Arrays.asList("Corrente", "Poupanca", "Salario"));
        int opcao = menuTipoConta.getSelection();

        if (opcao == 1) {
            return "Corrente";
        }

        if (opcao == 2) {
            return "Poupanca";
        }

        return "Salario";
    }

    public List<Conta> getContas() {
        return contas;
    }

    private boolean clienteJaPossuiConta(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCliente().getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    private boolean contaJaExiste(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return true;
            }
        }

        return false;
    }
}