package br.edu.iftm.hotel.spring.domain.cliente.juridica;

import br.edu.iftm.hotel.spring.domain.cliente.ClienteForm;

public class PessoaJuridicaForm extends ClienteForm {

    private String cnpj;
    private String nomeFantasia;

    public PessoaJuridicaForm() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
