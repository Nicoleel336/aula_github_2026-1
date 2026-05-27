import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteService {
    private final List<Cliente> clientes;
    private final Scanner scanner;

    public ClienteService() {
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");

        String nome = lerCampoObrigatorio("Nome");
        String cpf = lerCampoObrigatorio("CPF");
        String email = lerCampoObrigatorio("E-mail");

        Cliente cliente = new Cliente(nome, cpf, email);
        clientes.add(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(cliente);
    }

    private String lerCampoObrigatorio(String nomeCampo) {
        String valor;

        do {
            System.out.print(nomeCampo + ": ");
            valor = scanner.nextLine().trim();

            if (valor.isEmpty()) {
                System.out.println("O campo " + nomeCampo + " é obrigatório.");
            }
        } while (valor.isEmpty());

        return valor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}