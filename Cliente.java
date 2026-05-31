public class Cliente {
    private final String nome;
    private final String cpf;
    private final String email;
    private final boolean ativo;

    public Cliente(String nome, String cpf, String email, Boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ativo = true;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
               "CPF: " + cpf + "\n" +
               "E-mail: " + email + "\n" +
               "Status: " + (ativo ? "Ativo" : "Inativo");
    }
}