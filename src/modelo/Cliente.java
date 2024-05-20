package modelo;


/**
 * Classe que representa uma pessoa.
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoPessoa; // "PJ" para pessoa jurídica ou "PF" para pessoa física

    

    // Construtor

    /**
     * Construtor vazio da classe Pessoa.
     * Você pode inicializar os atributos com valores padrão aqui, se desejar.
     */
    public Cliente() {
    }

    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome     O nome da pessoa.
     * @param endereco O endereço da pessoa.
     * @param telefone O telefone da pessoa.
     * @param tipoPessoa O tipo de pessoa (PF ou PJ).
     */
    public Cliente(String nome, String endereco, String telefone, String tipoPessoa) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }

    // Getters e Setters

    /**
     * Obtém o nome da pessoa.
     * 
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome O nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço da pessoa.
     * 
     * @return O endereço da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da pessoa.
     * 
     * @param endereco O endereço da pessoa.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone da pessoa.
     * 
     * @return O telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     * 
     * @param telefone O telefone da pessoa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * Retorna uma representação em string da pessoa.
     * 
     * @return Uma string contendo o nome, endereço e telefone da pessoa.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nTipo de Pessoa: " + tipoPessoa;
    }
}