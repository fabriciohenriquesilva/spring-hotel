package br.edu.iftm.hotel.spring.domain.cliente;

import br.edu.iftm.hotel.spring.domain.cliente.fisica.PessoaFisica;
import br.edu.iftm.hotel.spring.domain.cliente.fisica.PessoaFisicaForm;
import br.edu.iftm.hotel.spring.domain.cliente.juridica.PessoaJuridica;
import br.edu.iftm.hotel.spring.domain.cliente.juridica.PessoaJuridicaForm;
import br.edu.iftm.hotel.spring.domain.endereco.Endereco;
import br.edu.iftm.hotel.spring.domain.endereco.EnderecoForm;
import br.edu.iftm.hotel.spring.domain.municipio.Municipio;
import br.edu.iftm.hotel.spring.domain.municipio.MunicipioRepository;
import br.edu.iftm.hotel.spring.domain.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    public Optional<? extends Cliente> cadastrar(ClienteForm form) {
        
        if (form instanceof PessoaFisicaForm) {
            PessoaFisica pessoaFisica = new PessoaFisica(form);
            
            if(form.getVeiculo() != null){
                pessoaFisica.getVeiculos().add(new Veiculo(form.getVeiculo()));
            }
            
            if(form.getEnderecoResidencial() == null) {
                throw new RuntimeException("Endereço Residencial deve ser preenchido");
            }

            if(form.getEnderecoComercial() != null) {
                Endereco enderecoComercial = criarEndereco(form.getEnderecoComercial());
                pessoaFisica.setEnderecoComercial(enderecoComercial);
            }

            Endereco enderecoResidencial = criarEndereco(form.getEnderecoResidencial());
            pessoaFisica.setEnderecoResidencial(enderecoResidencial);

            clienteRepository.save(pessoaFisica);

            return Optional.of(pessoaFisica);
        }

        if (form instanceof PessoaJuridicaForm) {
            PessoaJuridica pessoaJuridica = new PessoaJuridica(form);

            if(form.getVeiculo() != null){
                pessoaJuridica.getVeiculos().add(new Veiculo(form.getVeiculo()));
            }

            if(form.getEnderecoResidencial() == null) {
                throw new RuntimeException("Endereço Residencial deve ser preenchido");
            }

            if(form.getEnderecoComercial() != null) {
                Endereco enderecoComercial = criarEndereco(form.getEnderecoComercial());
                pessoaJuridica.setEnderecoComercial(enderecoComercial);
            }

            Endereco enderecoResidencial = criarEndereco(form.getEnderecoResidencial());
            pessoaJuridica.setEnderecoResidencial(enderecoResidencial);

            clienteRepository.save(pessoaJuridica);

            return Optional.of(pessoaJuridica);
        }
        return Optional.empty();
    }

    private Endereco criarEndereco(EnderecoForm enderecoForm) {

        Long municipioId = enderecoForm.getMunicipioId();

        Municipio municipio = municipioRepository.findById(municipioId)
                .orElseThrow(() -> new NoSuchElementException("Municipio informado não existe"));

        Endereco endereco = new Endereco(enderecoForm);
        endereco.setMunicipio(municipio);

        return endereco;
    }

}
