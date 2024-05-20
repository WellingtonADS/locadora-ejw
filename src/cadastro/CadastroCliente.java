package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 * Classe responsável por realizar o cadastro de clientes.
 */
public class CadastroCliente {
    private List<Cliente> clientes;

    /**
     * Construtor da classe CadastroCliente.
     * Inicializa a lista de clientes.
     */
    public CadastroCliente() {
        clientes = new ArrayList<>();
    }

    /**
     * Adiciona um cliente à lista de clientes cadastrados.
     * @param cliente O cliente a ser adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Remove um cliente da lista de clientes cadastrados.
     * @param cliente O cliente a ser removido.
     */
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    /**
     * Busca um cliente pelo nome completo.
     * @param nomeCompleto O nome completo do cliente a ser buscado.
     * @return O cliente encontrado, ou null se não encontrado.
     */
    public Cliente buscarClientePorNome(String nomeCompleto) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCompleto)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Atualiza os dados de um cliente existente.
     * @param clienteAtualizado O cliente com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getNome().equalsIgnoreCase(clienteAtualizado.getNome())) {
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Exibe todos os clientes cadastrados.
     */
    public void exibirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
