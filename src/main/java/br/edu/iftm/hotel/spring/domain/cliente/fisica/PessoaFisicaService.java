package br.edu.iftm.hotel.spring.domain.cliente.fisica;

import br.edu.iftm.hotel.spring.domain.endereco.Endereco;
import br.edu.iftm.hotel.spring.domain.endereco.EnderecoForm;
import br.edu.iftm.hotel.spring.domain.municipio.Municipio;
import br.edu.iftm.hotel.spring.domain.municipio.MunicipioRepository;
import br.edu.iftm.hotel.spring.domain.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;

    @Autowired
    private MunicipioRepository municipioRepository;

    public Optional<PessoaFisica> validarFormulario(PessoaFisicaForm form) {

        PessoaFisica pessoaFisica = new PessoaFisica(form);

        if (form.getVeiculos() != null) {
            form.getVeiculos().stream().forEach(v -> {
                pessoaFisica.getVeiculos().add(new Veiculo(v));
            });

            for(Veiculo v : pessoaFisica.getVeiculos()) {
                v.setCliente(pessoaFisica);
            }
        }

        if (form.getEnderecoResidencial() == null) {
            throw new RuntimeException("Endereço Residencial deve ser preenchido");
        }

        if (form.getEnderecoComercial() != null) {
            Endereco enderecoComercial = criarEndereco(form.getEnderecoComercial());
            pessoaFisica.setEnderecoComercial(enderecoComercial);
        }

        Endereco enderecoResidencial = criarEndereco(form.getEnderecoResidencial());
        pessoaFisica.setEnderecoResidencial(enderecoResidencial);

//        if (form.getVeiculos() != null) {
//
//            for(Veiculo veiculo : pessoaFisica.getVeiculos()){
//                veiculo.setCliente(pessoaFisica);
//            }
//        }
        repository.save(pessoaFisica);

        return Optional.of(pessoaFisica);

    }

    private Endereco criarEndereco(EnderecoForm enderecoForm) {

        Long municipioId = enderecoForm.getMunicipioId();

        Municipio municipio = municipioRepository.findById(municipioId)
                .orElseThrow(() -> new NoSuchElementException("Municipio informado não existe"));

        Endereco endereco = new Endereco(enderecoForm);
        endereco.setMunicipio(municipio);

        return endereco;
    }

    public Optional<Municipio> buscarMunicipio(Long id) {
        if (id != null) {
            return Optional.of(municipioRepository.findById(id))
                    .orElseThrow(() -> new NoSuchElementException("Municipio informado não existe"));
        }
        return Optional.empty();
    }

    public PessoaFisica atualizarDados(PessoaFisicaFormAtualizacao editForm) {

        EnderecoForm enderecoComercialForm = editForm.getEnderecoComercial();
        EnderecoForm enderecoResidencialForm = editForm.getEnderecoResidencial();

        PessoaFisica pessoaFisica = repository.findById(editForm.getId()).get();

        if(enderecoComercialForm != null){
            Municipio municipioComercial = buscarMunicipio(enderecoComercialForm.getMunicipioId()).get();
            pessoaFisica.getEnderecoComercial().setMunicipio(municipioComercial);
        }

        if(enderecoResidencialForm != null){
            Municipio municipioResidencial = buscarMunicipio(enderecoResidencialForm.getMunicipioId()).get();
            pessoaFisica.getEnderecoResidencial().setMunicipio(municipioResidencial);
        }

        pessoaFisica.atualizarDados(editForm);
        return pessoaFisica;
    }
}
