import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %s: R$ %.2f", dataHora.format(formatter), tipo, valor);
    }
    
}
