package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.cliente.Cliente;
import br.edu.iftm.hotel.spring.domain.cliente.ClienteForm;
import br.edu.iftm.hotel.spring.domain.endereco.Endereco;

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

    public void atualizarDados(PessoaFisicaFormAtualizacao editForm) {
        if(editForm.getNome() != null) {
            super.setNome(editForm.getNome());
        }
        if(editForm.getCpf() != null) {
            this.setCpf(editForm.getCpf());
        }
        if(editForm.getTelefoneCelular() != null){
            super.setTelefoneCelular(editForm.getTelefoneCelular());
        }
        if(editForm.getTelefoneComercial() != null){
            super.setTelefoneComercial(editForm.getTelefoneComercial());
        }
        if(editForm.getTelefoneFixo() != null){
            super.setTelefoneFixo(editForm.getTelefoneFixo());
        }
        if(editForm.getEnderecoResidencial() != null){
            super.getEnderecoResidencial().atualizarDados(editForm.getEnderecoResidencial());
        }
        if(editForm.getEnderecoComercial() != null){
            super.getEnderecoComercial().atualizarDados(editForm.getEnderecoComercial());
        }
    }
}
