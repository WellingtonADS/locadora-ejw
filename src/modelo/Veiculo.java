package modelo;

import java.util.Objects;

public class Veiculo {
    private String modelo;
    private String marca;
    private int ano;
    private double valorDiaria;

    public Veiculo() {}

    public Veiculo(String modelo, String marca, int ano, double valorDiaria) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", valorDiaria=" + valorDiaria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.ano &&
               Double.compare(veiculo.valorDiaria, valorDiaria) == 0 &&
               Objects.equals(modelo, veiculo.modelo) &&
               Objects.equals(marca, veiculo.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ano, valorDiaria);
    }
}
