package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Aluguel;

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

}
