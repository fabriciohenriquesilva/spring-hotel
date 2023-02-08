package br.edu.iftm.hotel.spring.controller;

import br.edu.iftm.hotel.spring.domain.municipio.Municipio;
import br.edu.iftm.hotel.spring.domain.municipio.MunicipioDto;
import br.edu.iftm.hotel.spring.domain.municipio.MunicipioForm;
import br.edu.iftm.hotel.spring.domain.municipio.MunicipioRepository;
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
@RequestMapping("municipios")
public class MunicipioController {

    @Autowired
    private MunicipioRepository repository;

    @GetMapping
    public Page<MunicipioDto> listar(@PageableDefault Pageable paginacao) {
        return repository.findAll(paginacao).map(MunicipioDto::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MunicipioDto> cadastrar(@RequestBody @Valid MunicipioForm form, UriComponentsBuilder uriBuilder) {
        Municipio municipio = repository.save(new Municipio(form));

        URI uri = uriBuilder
                .path("/medicos/{id}")
                .buildAndExpand(municipio.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new MunicipioDto(municipio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDto> consultar(@PathVariable Long id) {
        Optional<Municipio> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new MunicipioDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MunicipioDto> atualizar(@RequestBody @Valid MunicipioDto municipioDto) {
        Optional<Municipio> optional = repository.findById(municipioDto.getId());

        if (optional.isPresent()) {
            Municipio municipio = optional.get();
            municipio.atualizarDados(municipioDto);
            return ResponseEntity.ok(new MunicipioDto(municipio));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
