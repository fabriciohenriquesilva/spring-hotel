package br.edu.iftm.hotel.spring.domain.cliente.juridica;

import br.edu.iftm.hotel.spring.domain.cliente.Cliente;
import br.edu.iftm.hotel.spring.domain.cliente.ClienteForm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String nomeFantasia;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(ClienteForm form) {
        super(form);
        PessoaJuridicaForm pessoaJuridicaForm = (PessoaJuridicaForm) form;
        this.cnpj = pessoaJuridicaForm.getCnpj();
        this.nomeFantasia = pessoaJuridicaForm.getNomeFantasia();
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
