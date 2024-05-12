package teste;

import modelo.Aluguel;

/**
 * Classe de teste para a classe Aluguel.
 */
public class TesteAluguel {

    public static void main(String[] args) {
        // Teste da classe Aluguel
        Aluguel aluguel1 = new Aluguel();
        System.out.println(aluguel1);
        System.out.println("Veículo: " + aluguel1.getVeiculo());
        System.out.println("Pessoa: " + aluguel1.getPessoa());
        System.out.println("Dias: " + aluguel1.getDias());
        System.out.println("Valor total: " + aluguel1.getValorTotal());
    }
}
