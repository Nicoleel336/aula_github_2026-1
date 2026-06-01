import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        ContaService contaService = new ContaService(clienteService);

        boolean executando = true;

        while (executando) {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
            int opcaoSelecionada = mainMenu.getSelection();

            if (opcaoSelecionada == 1) {
                executarMenuConta(contaService);
            } else if (opcaoSelecionada == 2) {
                executarMenuCliente(clienteService);
            } else if (opcaoSelecionada == 3) {
                executarMenuOperacoes(contaService);
            } else if (opcaoSelecionada == 4) {
                executando = false;
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        System.out.println("Fim");
    }

    private static void executarMenuConta(ContaService contaService) {
        Menu contaMenu = new Menu("Menu Conta", Arrays.asList("Abrir Conta", "Voltar"));
        int opcaoConta = contaMenu.getSelection();

        if (opcaoConta == 1) {
            contaService.abrirConta();
        } else if (opcaoConta == 2) {
            System.out.println("Retornando ao menu principal.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    private static void executarMenuCliente(ClienteService clienteService) {
        Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar Cliente", "Consultar Cliente", "Voltar"));
        int opcaoCliente = clienteMenu.getSelection();

        if (opcaoCliente == 1) {
            clienteService.cadastrarCliente();
        } else if (opcaoCliente == 2) {
            clienteService.consultarCliente();
        } else if (opcaoCliente == 3) {
            System.out.println("Retornando ao menu principal.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    private static void executarMenuOperacoes(ContaService contaService) {
        Menu operacoesMenu = new Menu("Menu Operacoes", Arrays.asList("Realizar Saque", "Voltar"));
        int opcaoOperacao = operacoesMenu.getSelection();

        if (opcaoOperacao == 1) {
            contaService.realizarSaque();
        } else if (opcaoOperacao == 2) {
            System.out.println("Retornando ao menu principal.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }
}