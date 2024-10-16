package br.com.api_produtos.api_produtos.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_produtos.api_produtos.model.dto.ProdutosDto;
import br.com.api_produtos.api_produtos.service.ProdutosService;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/produtos",
        consumes = MediaType.APPLICATION_JSON,
        produces = MediaType.APPLICATION_JSON)
public class ProdutosController {

    private final ProdutosService produtosService;

    //metodos get: byId e getAll
    public ResponseEntity<Page<ProdutosDto>> findAll(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(produtosService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtosService.findById(id));
    }

    //metodo Post:
    @PostMapping
    public ResponseEntity<ProdutosDto> save(@RequestBody @Valid ProdutosDto produtosDto) {
        return ResponseEntity.status(201).body(produtosService.save(produtosDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDto> update(@PathVariable Long id, @RequestBody @Valid ProdutosDto produtosDto) {
        return ResponseEntity.ok(produtosService.update(id, produtosDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        produtosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
