import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String numero;
    private final String tipo;
    private final double saldoInicial;
    private double saldo;
    private final Cliente cliente;
    private final double limiteDiarioSaque = 1000.00; 
    private double saquesRealizadosHoje = 0.0;
    private final List<Transacao> transacoes;  

    public Conta(String numero, String tipo, double saldoInicial, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.saldo = saldoInicial;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
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
    
    public double getLimiteDisponivel() {
        return limiteDiarioSaque - saquesRealizadosHoje;
    }

    public void registrarSaque(double valor) {
        this.saquesRealizadosHoje += valor;
    }
    
    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void adicionarTransaacao(String tipo, double valor) {
       this.transacoes.add(new Transacao(tipo, valor));
    }

    @Override
    public String toString() {
        return "Numero da conta: " + numero + "\n" +
               "Tipo da conta: " + tipo + "\n" +
               "Saldo atual: R$ " + String.format("%.2f", saldo) + "\n" +
               "Cliente associado: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")";
    }
}