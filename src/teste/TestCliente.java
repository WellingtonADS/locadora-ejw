package teste;

import modelo.Cliente;

/**
 * Classe de teste para a classe Cliente.
 * 
 * Esta classe contém um método main que realiza testes na classe Cliente.
 * Ela cria uma instância de Cliente, define seus atributos com valores específicos e 
 * imprime as informações na saída padrão.
 */
public class TestCliente {

    public static void main(String[] args) {
        // Criar e definir atributos para o objeto Cliente
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setEndereco("Rua Brasil, 123 - Centro");
        cliente1.setTelefone("(11) 9999-9999");
        cliente1.setTipoPessoa("Física");

        // Imprimir informações do Cliente
        System.out.println("Dados do Cliente:");
        System.out.println(cliente1); // Imprime a representação completa do objeto
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Endereço: " + cliente1.getEndereco());
        System.out.println("Telefone: " + cliente1.getTelefone());
        System.out.println("Tipo de Pessoa: " + cliente1.getTipoPessoa());
    }
}
