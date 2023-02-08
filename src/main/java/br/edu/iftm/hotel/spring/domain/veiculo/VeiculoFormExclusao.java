package br.edu.iftm.hotel.spring.domain.veiculo;

import javax.validation.constraints.NotNull;

public class VeiculoFormExclusao {

    @NotNull
    private Long id;

    public VeiculoFormExclusao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
