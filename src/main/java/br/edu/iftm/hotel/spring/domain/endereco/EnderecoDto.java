package br.edu.iftm.hotel.spring.domain.endereco;

import br.edu.iftm.hotel.spring.domain.municipio.MunicipioDto;

public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private MunicipioDto municipio;

    public EnderecoDto() {
    }

    public EnderecoDto(Endereco enderecoResidencial) {
        if (enderecoResidencial.getId() != null) this.id = enderecoResidencial.getId();
        this.logradouro = enderecoResidencial.getLogradouro();
        this.numero = enderecoResidencial.getNumero();
        this.bairro = enderecoResidencial.getBairro();
        this.complemento = enderecoResidencial.getComplemento();
        this.cep = enderecoResidencial.getCep();
        this.municipio = new MunicipioDto(enderecoResidencial.getMunicipio());
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

    public MunicipioDto getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDto municipio) {
        this.municipio = municipio;
    }
}
