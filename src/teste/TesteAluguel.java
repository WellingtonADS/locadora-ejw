package teste;

import modelo.Aluguel;
import modelo.Cliente;
import modelo.Veiculo;

/**
 * Classe de teste para a classe Aluguel.
 */

 /*  private Veiculo veiculo;
    private Cliente cliente;
    private int dias;
    private double valorTotal;*/
public class TesteAluguel {

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Gol", "Volkswagen", 2020, 100.0);
        Cliente cliente = new Cliente("João", "Rua 1", "1234-5678", "PF");
        Aluguel aluguel = new Aluguel(veiculo, cliente, 5);

        System.out.println("Veículo: " + aluguel.getVeiculo().getModelo());
        System.out.println("Cliente: " + aluguel.getCliente().getNome());
        System.out.println("Dias: " + aluguel.getDias());
        System.out.println("Valor total: " + aluguel.getValorTotal());
        

    }
}
