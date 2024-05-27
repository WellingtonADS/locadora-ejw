package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class CadastroCliente {
    private List<Cliente> clientes;

    public CadastroCliente() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean removerCliente(String nome) {
        Cliente cliente = buscarClientePorNome(nome);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

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

    public List<Cliente> getListaClientes() {
        return clientes;
    }

    public Cliente[] getClientes() {
        return clientes.toArray(new Cliente[0]);
    }
}
