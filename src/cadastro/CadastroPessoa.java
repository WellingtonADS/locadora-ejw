package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;

/**
 * Classe responsável por realizar o cadastro de pessoas.
 */
public class CadastroPessoa {
    private List<Pessoa> pessoas;

    /**
     * Construtor da classe CadastroPessoa.
     * Inicializa a lista de pessoas.
     */
    public CadastroPessoa() {
        pessoas = new ArrayList<>();
    }

    /**
     * Adiciona uma pessoa à lista de pessoas cadastradas.
     * @param pessoa A pessoa a ser adicionada.
     */
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    /**
     * Remove uma pessoa da lista de pessoas cadastradas.
     * @param pessoa A pessoa a ser removida.
     */
    public void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    /**
     * Exibe todas as pessoas cadastradas.
     */
    public void exibirPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }

    /**
     * Cadastra uma nova pessoa com os dados fornecidos.
     * @param nome O nome da pessoa.
     * @param endereco O endereço da pessoa.
     * @param telefone O telefone da pessoa.
     */
    public void cadastrarPessoa(String nome, String endereco, String telefone) {
        Pessoa novaPessoa = new Pessoa(nome, endereco, telefone);
        pessoas.add(novaPessoa);
    }
}