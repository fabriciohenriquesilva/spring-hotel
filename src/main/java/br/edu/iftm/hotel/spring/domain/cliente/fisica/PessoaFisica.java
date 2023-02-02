package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.cliente.Cliente;
import br.edu.iftm.hotel.spring.domain.cliente.ClienteForm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(ClienteForm form) {
        super(form);
        PessoaFisicaForm pessoaFisicaForm = (PessoaFisicaForm) form;
        this.cpf = pessoaFisicaForm.getCpf();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
