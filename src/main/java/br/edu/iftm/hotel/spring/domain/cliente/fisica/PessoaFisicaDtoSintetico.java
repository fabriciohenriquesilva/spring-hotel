package br.edu.iftm.hotel.spring.domain.cliente.fisica;

public class PessoaFisicaDtoSintetico {

    private Long id;
    private String nome;
    private String cpf;
    private String telefoneCelular;

    public PessoaFisicaDtoSintetico() {
    }

    public PessoaFisicaDtoSintetico(PessoaFisica pessoaFisica) {
        this.id = pessoaFisica.getId();
        this.cpf = pessoaFisica.getCpf();
        this.nome = pessoaFisica.getNome();
        this.telefoneCelular = pessoaFisica.getTelefoneCelular();
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

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
