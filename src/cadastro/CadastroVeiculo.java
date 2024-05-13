package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;



/**
 * Classe responsável por realizar o cadastro de veículos na locadora.
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
     * 
     * @param veiculo O veículo a ser adicionado.
     */
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    /**
     * Remove um veículo da lista de veículos cadastrados.
     * 
     * @param veiculo O veículo a ser removido.
     */
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    /**
     * Exibe todos os veículos cadastrados.
     */
    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    /**
     * Cadastra um novo veículo na locadora.
     * 
     * @param modelo      O modelo do veículo.
     * @param marca       A marca do veículo.
     * @param ano         O ano de fabricação do veículo.
     * @param valorDiaria O valor da diária do veículo.
     */
    public void cadastrarVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo novoVeiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.add(novoVeiculo);
    }
    
}
