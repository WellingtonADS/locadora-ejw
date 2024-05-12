package teste;

import modelo.Pessoa;

/**
 * Classe de teste para a classe Pessoa.
 * 
 * Esta classe contém um método main que realiza testes na classe Pessoa.
 * Ela cria uma instância de Pessoa, define seus atributos e imprime as informações na saída padrão.
 */
public class TestPessoa {

    public static void main(String[] args) {
        // Teste da classe Pessoa
        Pessoa pessoa1 = new Pessoa("João", "Rua 1", "1234-5678");
        System.out.println(pessoa1);
        System.out.println("Nome: " + pessoa1.getNome());
        System.out.println("Endereço: " + pessoa1.getEndereco());
        System.out.println("Telefone: " + pessoa1.getTelefone());
    }
 

}
