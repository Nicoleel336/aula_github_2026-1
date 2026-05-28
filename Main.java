import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        boolean executando = true;

        while (executando) {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
            int opcaoSelecionada = mainMenu.getSelection();

            if (opcaoSelecionada == 1) {
                System.out.println("Modulo Conta ainda nao implementado.");
            } else if (opcaoSelecionada == 2) {
                executarMenuCliente(clienteService);
            } else if (opcaoSelecionada == 3) {
                System.out.println("Modulo Operacoes ainda nao implementado.");
            } else if (opcaoSelecionada == 4) {
                executando = false;
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        System.out.println("Fim");
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
}