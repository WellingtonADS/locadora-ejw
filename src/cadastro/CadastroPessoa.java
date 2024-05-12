package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;

public class CadastroPessoa {
    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public void exibirPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }

    public void cadastrarPessoa(String nome, String endereco, String telefone) {
        // Cria uma nova instância de Pessoa com os dados fornecidos
        Pessoa novaPessoa = new Pessoa(nome, endereco, telefone);
        // Adiciona a nova pessoa à lista de pessoas cadastradas
        pessoas.add(novaPessoa);
    }





}