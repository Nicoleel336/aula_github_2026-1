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

    public void consultarCliente() {
        System.out.println("\n=== Consulta de Cliente ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        String cpf = lerCampoObrigatorio("CPF do cliente");

        Cliente clienteEncontrado = buscarClientePorCpf(cpf);

        if (clienteEncontrado == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }

        System.out.println("\nCliente encontrado:");
        System.out.println(clienteEncontrado);
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
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

    public List<Cliente> getClientes() {
        return clientes;
    }
}