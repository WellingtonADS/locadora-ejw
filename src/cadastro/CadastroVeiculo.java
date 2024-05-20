package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;

/**
 * Classe responsável por realizar o cadastro de veículos.
 */
public class CadastroVeiculo {
    private List<Veiculo> veiculos;

    /**
     * Construtor da classe CadastroVeiculo.
     * Inicializa a lista de veículos.
     */
    public CadastroVeiculo() {
        veiculos = new ArrayList<>();
    }

    /**
     * Adiciona um veículo à lista de veículos cadastrados.
     * @param veiculo O veículo a ser adicionado.
     */
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    /**
     * Remove um veículo da lista de veículos cadastrados.
     * @param veiculo O veículo a ser removido.
     */
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    /**
     * Busca um veículo pelo modelo e marca.
     * @param modelo O modelo do veículo a ser buscado.
     * @param marca A marca do veículo a ser buscado.
     * @return O veículo encontrado, ou null se não encontrado.
     */
    public Veiculo buscarVeiculo(String modelo, String marca) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo) && veiculo.getMarca().equalsIgnoreCase(marca)) {
                return veiculo;
            }
        }
        return null;
    }

    /**
     * Atualiza os dados de um veículo existente.
     * @param veiculoAtualizado O veículo com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    public boolean atualizarVeiculo(Veiculo veiculoAtualizado) {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (veiculo.getModelo().equalsIgnoreCase(veiculoAtualizado.getModelo()) &&
                veiculo.getMarca().equalsIgnoreCase(veiculoAtualizado.getMarca())) {
                veiculos.set(i, veiculoAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Exibe todos os veículos cadastrados.
     */
    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }
}
