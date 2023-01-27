package br.edu.iftm.hotel.spring.domain.municipio;

import javax.validation.constraints.NotNull;

public class MunicipioDto {

    @NotNull
    private Long id;
    private String nome;
    private String estado;
    private String pais;

    public MunicipioDto() {
    }

    public MunicipioDto(Municipio municipio) {
        this.id = municipio.getId();
        this.nome = municipio.getNome();
        this.estado = municipio.getEstado();
        this.pais = municipio.getPais();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
