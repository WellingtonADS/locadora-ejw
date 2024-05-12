package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;



public class CadastroVeiculo {

    private List<Veiculo> veiculos;

    public CadastroVeiculo() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    public void cadastrarVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo novoVeiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.add(novoVeiculo);
    }
    
}
