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
     * Adiciona um cliente à lista de clientes.
     * 
     * @param cliente O cliente a ser adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Remove um cliente da lista de clientes pelo nome.
     * 
     * @param nome O nome do cliente a ser removido.
     * @return true se o cliente foi removido com sucesso, false caso contrário.
     */
    public boolean removerCliente(String nome) {
        Cliente cliente = buscarClientePorNome(nome);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    /**
     * Busca um cliente na lista de clientes pelo nome.
     * 
     * @param nome O nome do cliente a ser buscado.
     * @return O cliente encontrado ou null se não encontrado.
     */
    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Atualiza um cliente na lista de clientes pelo nome.
     * 
     * @param nomeAntigo O nome do cliente a ser atualizado.
     * @param clienteAtualizado O cliente com as informações atualizadas.
     * @return true se o cliente foi atualizado com sucesso, false caso contrário.
     */
    public boolean atualizarCliente(String nomeAntigo, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getNome().equalsIgnoreCase(nomeAntigo)) {
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna a lista de clientes cadastrados.
     * 
     * @return A lista de clientes.
     */
    public List<Cliente> getListaClientes() {
        return clientes;
    }

    /**
     * Retorna um array de clientes cadastrados.
     * 
     * @return O array de clientes.
     */
    public Cliente[] getClientes() {
        return clientes.toArray(new Cliente[0]);
    }
}
