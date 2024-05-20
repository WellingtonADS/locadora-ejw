package teste;

import java.time.LocalDate;
import modelo.Aluguel;
import modelo.Cliente;
import modelo.Veiculo;

/**
 * Classe de teste para a classe Aluguel.
 */
public class TesteAluguel {

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Gol", "Volkswagen", 2020, 100.0);
        Cliente cliente = new Cliente("João", "Rua 1", "1234-5678", "PF");

        LocalDate dataInicio = LocalDate.of(2024, 5, 1); // Exemplo de data de início
        LocalDate dataFim = LocalDate.of(2024, 5, 5);    // Exemplo de data de fim

        Aluguel aluguel = new Aluguel (cliente, veiculo, dataInicio, dataFim);

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Tipo de Pessoa: " + cliente.getTipoPessoa());
        System.out.println("Veículo: " + aluguel.getVeiculo());
        System.out.println("Data de Início: " + aluguel.getDataInicio());
        System.out.println("Data de Fim: " + aluguel.getDataFim());      
        
    }
}
