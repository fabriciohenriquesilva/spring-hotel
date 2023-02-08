package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.endereco.EnderecoForm;

import javax.validation.constraints.NotNull;

public class PessoaFisicaFormAtualizacao {

    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    private String telefoneFixo;
    private String telefoneCelular;
    private String telefoneComercial;
    @NotNull
    private EnderecoForm enderecoResidencial;
    private EnderecoForm enderecoComercial;

    public PessoaFisicaFormAtualizacao() {
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

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public EnderecoForm getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(EnderecoForm enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public EnderecoForm getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(EnderecoForm enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
