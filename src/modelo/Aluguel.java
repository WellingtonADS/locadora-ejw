package modelo;

/**
 * A classe Aluguel representa um aluguel de veículo realizado por uma pessoa.
 * 
 * Ela possui atributos como o veículo alugado, a pessoa que realizou o aluguel,
 * a quantidade de dias do aluguel e o valor total do aluguel.
 */
public class Aluguel {

    private Veiculo veiculo;
    private Pessoa pessoa;
    private int dias;
    private double valorTotal;

    // Constructor

    /**
     * Construtor vazio da classe Aluguel.
     * 
     * Cria um objeto Aluguel sem atributos definidos.
     * Os atributos podem ser inicializados posteriormente através dos setters.
     */
    public Aluguel() {
        // Este é um construtor vazio
        // Você pode inicializar os atributos com valores padrão aqui, se desejar
    }

    /**
     * Construtor da classe Aluguel.
     * 
     * Cria um objeto Aluguel com os atributos definidos.
     * O valor total do aluguel é calculado multiplicando a quantidade de dias pelo valor diário do veículo.
     * 
     * @param veiculo O veículo alugado.
     * @param pessoa A pessoa que realizou o aluguel.
     * @param dias A quantidade de dias do aluguel.
     */
    public Aluguel(Veiculo veiculo, Pessoa pessoa, int dias) {
        this.veiculo = veiculo;
        this.pessoa = pessoa;
        this.dias = dias;
        this.valorTotal = dias * veiculo.getValorDiaria();
    }

    // Getters and Setters

    /**
     * Retorna o veículo alugado.
     * 
     * @return O veículo alugado.
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Define o veículo alugado.
     * 
     * @param veiculo O veículo alugado.
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Retorna a pessoa que realizou o aluguel.
     * 
     * @return A pessoa que realizou o aluguel.
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Define a pessoa que realizou o aluguel.
     * 
     * @param pessoa A pessoa que realizou o aluguel.
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * Retorna a quantidade de dias do aluguel.
     * 
     * @return A quantidade de dias do aluguel.
     */
    public int getDias() {
        return dias;
    }

    /**
     * Define a quantidade de dias do aluguel.
     * 
     * @param dias A quantidade de dias do aluguel.
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * Retorna o valor total do aluguel.
     * 
     * @return O valor total do aluguel.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total do aluguel.
     * 
     * @param valorTotal O valor total do aluguel.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Retorna uma representação em string do objeto Aluguel.
     * 
     * @return Uma representação em string do objeto Aluguel.
     */
    @Override
    public String toString() {
        return "Veículo: " + veiculo + "\n" + "Pessoa: " + pessoa + "\n" + "Dias: " + dias + "\n" + "Valor total: "
                + valorTotal;
    }

}
