package br.edu.iftm.hotel.spring.controller;

import br.edu.iftm.hotel.spring.domain.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public Page<? extends Cliente> listar(@PageableDefault Pageable paginacao) {
        return clienteRepository.findAll(paginacao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {

        Optional<? extends Cliente> optional = clienteService.cadastrar(form);

        if(optional.isPresent()){
            Cliente cliente = optional.get();

            URI uri = uriBuilder
                    .path("/clientes/{id}")
                    .buildAndExpand(cliente.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(cliente);
        }
        return ResponseEntity.noContent().build();
    }
}
