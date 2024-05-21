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

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

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

    public void exibirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
