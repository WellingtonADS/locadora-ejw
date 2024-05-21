package modelo;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoPessoa;

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String telefone, String tipoPessoa) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "nome='" + nome + '\'' +
               ", endereco='" + endereco + '\'' +
               ", telefone='" + telefone + '\'' +
               ", tipoPessoa='" + tipoPessoa + '\'' +
               '}';
    }
}
