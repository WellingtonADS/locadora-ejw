package modelo;


/**
 * Classe que representa uma pessoa.
 */
public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;

    // Construtor

    /**
     * Construtor vazio da classe Pessoa.
     * Você pode inicializar os atributos com valores padrão aqui, se desejar.
     */
    public Pessoa() {
    }

    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome     O nome da pessoa.
     * @param endereco O endereço da pessoa.
     * @param telefone O telefone da pessoa.
     */
    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
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

    /**
     * Retorna uma representação em string da pessoa.
     * 
     * @return Uma string contendo o nome, endereço e telefone da pessoa.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone;
    }
}