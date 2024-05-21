package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;



public class CadastroVeiculo {
    private List<Veiculo> veiculos;

    public CadastroVeiculo() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo veiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.add(veiculo);
    }

    public void removerVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo veiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.remove(veiculo);
    }

    public Veiculo buscarVeiculoPorModelo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    public void atualizarVeiculo(String modelo, String marca, int ano, double valorDiaria) {
        Veiculo veiculo = new Veiculo(modelo, marca, ano, valorDiaria);
        veiculos.add(veiculo);
    }

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

    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    

    
}
