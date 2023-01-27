package br.edu.iftm.hotel.spring.domain.municipio;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String estado;
    private String pais;

    public Municipio() {
    }

    public Municipio(MunicipioForm form) {
        this.nome = form.getNome();
        this.estado = form.getEstado();
        this.pais = form.getPais();
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

    public void atualizarDados(MunicipioDto municipioDto) {
        if(municipioDto.getNome() != null) {
            this.nome = municipioDto.getNome();
        }
        if(municipioDto.getEstado() != null) {
            this.estado = municipioDto.getEstado();
        }
        if(municipioDto.getPais() != null) {
            this.pais = municipioDto.getPais();
        }
    }
}
