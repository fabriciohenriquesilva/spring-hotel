package br.edu.iftm.hotel.spring.domain.municipio;

import javax.validation.constraints.NotNull;

public class MunicipioForm {

    @NotNull
    private String nome;
    @NotNull
    private String estado;
    @NotNull
    private String pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
