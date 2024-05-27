package cadastro;

import java.util.ArrayList;
import java.util.Iterator;
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

    public Veiculo buscarVeiculoPorModelo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null;
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void exibirVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    public List<Veiculo> getListaVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
}
