import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
        int opcaoSelecionada = mainMenu.getSelection();

        if (opcaoSelecionada == 1) {
            System.out.println("Modulo Conta ainda nao implementado.");
        } else if (opcaoSelecionada == 2) {
            Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar Cliente"));
            int opcaoCliente = clienteMenu.getSelection();

            if (opcaoCliente == 1) {
                clienteService.cadastrarCliente();
            } else {
                System.out.println("Opcao invalida.");
            }
        } else if (opcaoSelecionada == 3) {
            System.out.println("Modulo Operacoes ainda nao implementado.");
        } else {
            System.out.println("Opcao invalida.");
        }

        System.out.println("Fim");
    }
}