package modelo;

import java.util.Objects;

/**
 * Classe que representa um veículo.
 */
public class Veiculo {
    private String modelo;
    private String marca;
    private int ano;
    private double valorDiaria;

    /**
     * Construtor padrão da classe Veiculo.
     */
    public Veiculo() {}

    /**
     * Construtor da classe Veiculo.
     * 
     * @param modelo O modelo do veículo.
     * @param marca A marca do veículo.
     * @param ano O ano do veículo.
     * @param valorDiaria O valor da diária do veículo.
     */
    public Veiculo(String modelo, String marca, int ano, double valorDiaria) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    /**
     * Obtém o modelo do veículo.
     * 
     * @return O modelo do veículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     * 
     * @param modelo O modelo do veículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém a marca do veículo.
     * 
     * @return A marca do veículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do veículo.
     * 
     * @param marca A marca do veículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o ano do veículo.
     * 
     * @return O ano do veículo.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano do veículo.
     * 
     * @param ano O ano do veículo.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Obtém o valor da diária do veículo.
     * 
     * @return O valor da diária do veículo.
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Define o valor da diária do veículo.
     * 
     * @param valorDiaria O valor da diária do veículo.
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    /**
     * Retorna uma representação em string do objeto Veiculo.
     * 
     * @return Uma representação em string do objeto Veiculo.
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

    /**
     * Compara se o objeto Veiculo é igual a outro objeto.
     * 
     * @param obj O objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Veiculo veiculo = (Veiculo) obj;
        return ano == veiculo.ano &&
               Double.compare(veiculo.valorDiaria, valorDiaria) == 0 &&
               Objects.equals(modelo, veiculo.modelo) &&
               Objects.equals(marca, veiculo.marca);
    }

    /**
     * Retorna o código hash do objeto Veiculo.
     * 
     * @return O código hash do objeto Veiculo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ano, valorDiaria);
    }
}
