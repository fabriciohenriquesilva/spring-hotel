package br.edu.iftm.hotel.spring.domain.veiculo;

import javax.validation.constraints.NotNull;

public class VeiculoForm {

    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    private String cor;
    private String placa;
    private String vagaOcupada;

    public VeiculoForm() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVagaOcupada() {
        return vagaOcupada;
    }

    public void setVagaOcupada(String vagaOcupada) {
        this.vagaOcupada = vagaOcupada;
    }
}
