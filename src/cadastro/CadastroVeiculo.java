package cadastro;

import java.util.ArrayList;
import java.util.Iterator;
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
     * Adiciona um novo veículo ao cadastro.
     * 
     * @param modelo o modelo do veículo
     * @param marca a marca do veículo
     * @param ano o ano de fabricação do veículo
     * @param valorDiaria o valor da diária do veículo
     */
    public void adicionarVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo veiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.add(veiculo);
    }

    /**
     * Remove um veículo do cadastro.
     * 
     * @param modelo o modelo do veículo
     * @param marca a marca do veículo
     * @param ano o ano de fabricação do veículo
     * @param valorDiaria o valor da diária do veículo
     * @return true se o veículo foi removido com sucesso, false caso contrário
     */
    public boolean removerVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getModelo().equalsIgnoreCase(modelo) &&
                veiculo.getMarca().equalsIgnoreCase(marca) &&
                veiculo.getAno() == ano &&
                veiculo.getValorDiaria() == valorDiaria) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Busca um veículo pelo modelo.
     * 
     * @param modelo o modelo do veículo a ser buscado
     * @return o veículo encontrado, ou null se não for encontrado nenhum veículo com o modelo informado
     */
    public Veiculo buscarVeiculoPorModelo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    /**
     * Atualiza as informações de um veículo no cadastro.
     * 
     * @param veiculoAtualizado o veículo com as informações atualizadas
     * @return true se o veículo foi atualizado com sucesso, false caso contrário
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
     * Retorna a lista de veículos cadastrados.
     * 
     * @return a lista de veículos cadastrados
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * Exibe os veículos cadastrados.
     */
    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    /**
     * Retorna a lista de veículos cadastrados.
     * 
     * @return a lista de veículos cadastrados
     */
    public List<Veiculo> getListaVeiculos() {
        return veiculos;
    }

    /**
     * Adiciona um veículo ao cadastro.
     * 
     * @param veiculo o veículo a ser adicionado
     */
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
}
