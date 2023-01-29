package br.edu.iftm.hotel.spring.domain.cliente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
