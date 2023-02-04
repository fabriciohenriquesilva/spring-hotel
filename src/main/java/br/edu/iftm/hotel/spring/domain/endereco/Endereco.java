package br.edu.iftm.hotel.spring.domain.endereco;

import br.edu.iftm.hotel.spring.domain.municipio.Municipio;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    @OneToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
    private String complemento;
    private String cep;

    public Endereco() {
    }

    public Endereco(EnderecoForm form) {
        this.logradouro = form.getLogradouro();
        this.numero = form.getNumero();
        this.bairro = form.getBairro();
        this.complemento = form.getComplemento();
        this.cep = form.getCep();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void atualizarDados(EnderecoForm form) {
        if(form.getLogradouro() != null) {
            this.logradouro = form.getLogradouro();
        }
        if(form.getNumero() != null) {
            this.numero = form.getNumero();
        }
        if(form.getBairro() != null) {
            this.bairro = form.getBairro();
        }
        if(form.getComplemento() != null) {
            this.complemento = form.getComplemento();
        }
        if(form.getCep() != null) {
            this.cep = form.getCep();
        }
    }
}
