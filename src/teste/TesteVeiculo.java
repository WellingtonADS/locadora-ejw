package teste;

import modelo.Veiculo;

/**
 * Classe de teste para a classe Veiculo.
 */
public class TesteVeiculo {

    public static void main(String[] args) {
        // Teste da classe Veiculo
        Veiculo veiculo1 = new Veiculo("Fusca", "Volkswagen", 1970, 100.0);
        System.out.println(veiculo1);
        System.out.println("Modelo: " + veiculo1.getModelo());
        System.out.println("Marca: " + veiculo1.getMarca());
        System.out.println("Ano: " + veiculo1.getAno());
        System.out.println("Valor da diária: " + veiculo1.getValorDiaria());
    }
}
