package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.endereco.EnderecoDto;
import br.edu.iftm.hotel.spring.domain.veiculo.VeiculoDto;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDtoAnalitico {

    private Long id;
    private String nome;
    private String cpf;
    private EnderecoDto enderecoResidencial;
    private EnderecoDto enderecoComercial;
    private List<VeiculoDto> veiculos = new ArrayList<>();
    private String telefoneFixo;
    private String telefoneCelular;
    private String telefoneComercial;
    private String tipoCliente;

    public PessoaFisicaDtoAnalitico() {
    }

    public PessoaFisicaDtoAnalitico(PessoaFisica pessoaFisica) {
        this.id = pessoaFisica.getId();
        this.cpf = pessoaFisica.getCpf();
        this.nome = pessoaFisica.getNome();

        if(pessoaFisica.getEnderecoResidencial() != null) {
            this.enderecoResidencial = new EnderecoDto(pessoaFisica.getEnderecoResidencial());
        }

        if(pessoaFisica.getEnderecoComercial() != null) {
            this.enderecoComercial = new EnderecoDto(pessoaFisica.getEnderecoComercial());
        }

        this.telefoneFixo = pessoaFisica.getTelefoneFixo();
        this.telefoneCelular = pessoaFisica.getTelefoneCelular();
        this.telefoneComercial = pessoaFisica.getTelefoneComercial();

        if(pessoaFisica.getVeiculos() != null && !pessoaFisica.getVeiculos().isEmpty()){
            pessoaFisica.getVeiculos().forEach(v -> this.veiculos.add(new VeiculoDto(v)));
        }
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoDto getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(EnderecoDto enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public EnderecoDto getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(EnderecoDto enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public List<VeiculoDto> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoDto> veiculos) {
        this.veiculos = veiculos;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
