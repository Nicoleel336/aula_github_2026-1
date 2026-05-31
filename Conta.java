public class Conta {
    private final String numero;
    private final String tipo;
    private final double saldoInicial;
    private final Cliente cliente;
    private double limiteDiarioSaque = 1000.00; 
    private double saquesRealizadosHoje = 0.0;  

    public Conta(String numero, String tipo, double saldoInicial, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
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

    public Cliente getCliente() {
        return cliente;
    }
<<<<<<< Updated upstream
=======
    
    public double getLimiteDisponivel() {
        return limiteDiarioSaque - saquesRealizadosHoje;
    }

    public void registrarSaque(double valor) {
        this.saquesRealizadosHoje += valor;
    }
    
    public void debitar(double valor) {
        this.saldo -= valor;
    }
>>>>>>> Stashed changes

    @Override
    public String toString() {
        return "Numero da conta: " + numero + "\n" +
               "Tipo da conta: " + tipo + "\n" +
               "Saldo inicial: R$ " + String.format("%.2f", saldoInicial) + "\n" +
               "Cliente associado: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")";
    }
}