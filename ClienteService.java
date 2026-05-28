import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        String cpf;
        do {
            cpf = lerCampoObrigatorio("CPF");
            if (!isValidCPF(cpf)) {
                System.out.println("CPF invalido. Informe um CPF no formato correto (somente numeros) e valido.");
                cpf = ""; 
            }
        } while (cpf.isEmpty());

        String email;
        do {
            email = lerCampoObrigatorio("E-mail");
            if (!isValidEmail(email)) {
                System.out.println("E-mail invalido. Informe um e-mail no formato exemplo@dominio.com.");
                email = "";
            }
        } while (email.isEmpty());

        Cliente cliente = new Cliente(nome, cpf, email);
        clientes.add(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(cliente);
    }

    private boolean isValidEmail(String email) {
        if (email == null) return false;
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    private boolean isValidCPF(String cpf) {
        if (cpf == null) return false;
        String digits = cpf.replaceAll("\\D", "");
        if (digits.length() != 11) return false;

        boolean allEqual = true;
        for (int i = 1; i < digits.length(); i++) {
            if (digits.charAt(i) != digits.charAt(0)) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) return false;

        try {
            int[] num = new int[11];
            for (int i = 0; i < 11; i++) num[i] = Character.getNumericValue(digits.charAt(i));

            int sum = 0;
            for (int i = 0; i < 9; i++) sum += num[i] * (10 - i);
            int r = sum % 11;
            int d1 = (r < 2) ? 0 : 11 - r;
            if (num[9] != d1) return false;

           
            sum = 0;
            for (int i = 0; i < 10; i++) sum += num[i] * (11 - i);
            r = sum % 11;
            int d2 = (r < 2) ? 0 : 11 - r;
            if (num[10] != d2) return false;

            return true;
        } catch (Exception e) {
            return false;
        }
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

    public Cliente encontrarClientePorCpf(String cpf) {
        return buscarClientePorCpf(cpf);
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