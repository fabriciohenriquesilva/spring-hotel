package br.edu.iftm.hotel.spring.domain.cliente;

import br.edu.iftm.hotel.spring.domain.cliente.fisica.PessoaFisicaForm;
import br.edu.iftm.hotel.spring.domain.cliente.juridica.PessoaJuridicaForm;
import br.edu.iftm.hotel.spring.domain.endereco.EnderecoForm;
import br.edu.iftm.hotel.spring.domain.veiculo.VeiculoForm;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "tipoCliente",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PessoaFisicaForm.class, name = "F"),
        @JsonSubTypes.Type(value = PessoaJuridicaForm.class, name = "J"),
})
public abstract class ClienteForm {

    @NotNull
    private String nome;
    @NotNull
    private String tipoCliente;
    private String telefoneFixo;
    private String telefoneCelular;
    private String telefoneComercial;
    private VeiculoForm veiculo;
    @NotNull
    private EnderecoForm enderecoResidencial;
    private EnderecoForm enderecoComercial;

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

    public VeiculoForm getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoForm veiculo) {
        this.veiculo = veiculo;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
