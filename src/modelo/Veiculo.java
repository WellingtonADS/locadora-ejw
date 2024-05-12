package modelo;

/**
 * Classe que representa um veículo.
 */
public class Veiculo {

    private String modelo;
    private String marca;
    private int ano;
    private double valorDiaria;

    // Constructor

    /**
     * Construtor vazio da classe Veiculo.
     * Você pode inicializar os atributos com valores padrão aqui, se desejar.
     */
    public Veiculo() {
    }

    /**
     * Construtor da classe Veiculo.
     * 
     * @param modelo o modelo do veículo
     * @param marca a marca do veículo
     * @param ano o ano do veículo
     * @param valorDiaria o valor da diária do veículo
     */
    public Veiculo(String modelo, String marca, int ano, double valorDiaria) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    // Getters and Setters

    /**
     * Retorna o modelo do veículo.
     * 
     * @return o modelo do veículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     * 
     * @param modelo o modelo do veículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna a marca do veículo.
     * 
     * @return a marca do veículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do veículo.
     * 
     * @param marca a marca do veículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o ano do veículo.
     * 
     * @return o ano do veículo
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano do veículo.
     * 
     * @param ano o ano do veículo
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Retorna o valor da diária do veículo.
     * 
     * @return o valor da diária do veículo
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Define o valor da diária do veículo.
     * 
     * @param valorDiaria o valor da diária do veículo
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    /**
     * Retorna uma representação em string do veículo.
     * 
     * @return uma representação em string do veículo
     */
    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
