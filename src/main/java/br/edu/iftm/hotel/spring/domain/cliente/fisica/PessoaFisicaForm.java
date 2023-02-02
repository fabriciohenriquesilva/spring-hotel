package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.cliente.ClienteForm;

public class PessoaFisicaForm extends ClienteForm {

    private String cpf;

    public PessoaFisicaForm() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
