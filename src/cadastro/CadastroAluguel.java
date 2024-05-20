package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Aluguel;
import modelo.Cliente;

/**
 * Classe responsável por realizar o cadastro de aluguéis na locadora.
 */
public class CadastroAluguel {
    private List<Aluguel> alugueis;

    /**
     * Construtor da classe CadastroAluguel.
     * Inicializa a lista de aluguéis.
     */
    public CadastroAluguel() {
        alugueis = new ArrayList<>();
    }

    /**
     * Adiciona um aluguel à lista de aluguéis.
     * @param aluguel O aluguel a ser adicionado.
     */
    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    /**
     * Remove um aluguel da lista de aluguéis.
     * @param aluguel O aluguel a ser removido.
     */
    public void removerAluguel(Aluguel aluguel) {
        alugueis.remove(aluguel);
    }

    /**
     * Exibe todos os aluguéis cadastrados.
     */
    public void exibirAlugueis() {
        for (Aluguel aluguel : alugueis) {
            System.out.println(aluguel);
        }
    }

    /**
     * Busca um aluguel pelo cliente associado.
     * @param cliente O cliente associado ao aluguel.
     * @return A lista de aluguéis encontrados para o cliente.
     */
    public List<Aluguel> buscarAlugueisPorCliente(Cliente cliente) {
        List<Aluguel> alugueisCliente = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente().equals(cliente)) {
                alugueisCliente.add(aluguel);
            }
        }
        return alugueisCliente;
    }

    /**
     * Atualiza os dados de um aluguel existente.
     * @param aluguelAtualizado O aluguel com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarAluguel(Aluguel aluguelAtualizado) {
        for (int i = 0; i < alugueis.size(); i++) {
            Aluguel aluguel = alugueis.get(i);
            if (aluguel.equals(aluguelAtualizado)) {
                alugueis.set(i, aluguelAtualizado);
                return true;
            }
        }
        return false;
    }
}
