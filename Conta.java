public class Conta {
    private final String numero;
    private final String tipo;
    private final double saldoInicial;
    private double saldo;
    private final Cliente cliente;

    public Conta(String numero, String tipo, double saldoInicial, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.saldo = saldoInicial;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void debitar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Numero da conta: " + numero + "\n" +
               "Tipo da conta: " + tipo + "\n" +
               "Saldo atual: R$ " + String.format("%.2f", saldo) + "\n" +
               "Cliente associado: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")";
    }
}