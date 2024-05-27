package modelo;

import java.time.LocalDate;

/**
 * Representa um aluguel de veículo realizado por um cliente.
 */
public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    /**
     * Cria um novo objeto Aluguel com as informações fornecidas.
     * 
     * @param cliente o cliente que realizou o aluguel
     * @param veiculo o veículo alugado
     * @param dataInicio a data de início do aluguel
     * @param dataFim a data de término do aluguel
     */
    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    /**
     * Retorna o cliente que realizou o aluguel.
     * 
     * @return o cliente do aluguel
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente que realizou o aluguel.
     * 
     * @param cliente o cliente do aluguel
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna o veículo alugado.
     * 
     * @return o veículo alugado
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Define o veículo alugado.
     * 
     * @param veiculo o veículo alugado
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Retorna a data de início do aluguel.
     * 
     * @return a data de início do aluguel
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    /**
     * Define a data de início do aluguel.
     * 
     * @param dataInicio a data de início do aluguel
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Retorna a data de término do aluguel.
     * 
     * @return a data de término do aluguel
     */
    public LocalDate getDataFim() {
        return dataFim;
    }

    /**
     * Define a data de término do aluguel.
     * 
     * @param dataFim a data de término do aluguel
     */
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Retorna uma representação em string do objeto Aluguel.
     * 
     * @return uma representação em string do objeto Aluguel
     */
    @Override
    public String toString() {
        return "Aluguel{" + "cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
