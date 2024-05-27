package modelo;

/**
 * Representa um cliente da locadora.
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoPessoa;

    /**
     * Construtor padrão da classe Cliente.
     */
    public Cliente() {
    }

    /**
     * Construtor da classe Cliente.
     * 
     * @param nome O nome do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O telefone do cliente.
     * @param tipoPessoa O tipo de pessoa do cliente.
     */
    public Cliente(String nome, String endereco, String telefone, String tipoPessoa) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * Obtém o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * 
     * @param nome O nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço do cliente.
     * 
     * @return O endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     * 
     * @param endereco O endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone do cliente.
     * 
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * 
     * @param telefone O telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o tipo de pessoa do cliente.
     * 
     * @return O tipo de pessoa do cliente.
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * Define o tipo de pessoa do cliente.
     * 
     * @param tipoPessoa O tipo de pessoa do cliente.
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * Retorna uma representação em string do objeto Cliente.
     * 
     * @return Uma representação em string do objeto Cliente.
     */
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
