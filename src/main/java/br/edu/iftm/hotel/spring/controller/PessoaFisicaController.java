package br.edu.iftm.hotel.spring.controller;

import br.edu.iftm.hotel.spring.domain.cliente.fisica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository repository;

    @Autowired
    private PessoaFisicaService service;

    @GetMapping
    public Page<PessoaFisicaDtoSintetico> listar(@PageableDefault Pageable paginacao) {
        return repository.findAll(paginacao).map(PessoaFisicaDtoSintetico::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PessoaFisicaForm form, UriComponentsBuilder uriBuilder) {

        Optional<PessoaFisica> optional = service.validarFormulario(form);

        if (optional.isPresent()) {
            PessoaFisica pessoaFisica = optional.get();

            URI uri = uriBuilder
                    .path("/pessoas-fisicas/{id}")
                    .buildAndExpand(pessoaFisica.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(pessoaFisica);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity visualizar(@PathVariable Long id) {
        Optional<PessoaFisica> optional = repository.findById(id);
        PessoaFisicaDtoAnalitico dto = new PessoaFisicaDtoAnalitico(optional.get());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid PessoaFisicaFormAtualizacao editForm) {
        PessoaFisica pessoaFisica = service.atualizarDados(editForm);
        return ResponseEntity.ok(new PessoaFisicaDtoAnalitico(pessoaFisica));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
