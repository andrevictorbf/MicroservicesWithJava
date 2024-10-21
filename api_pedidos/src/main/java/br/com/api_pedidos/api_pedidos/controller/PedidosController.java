package br.com.api_pedidos.api_pedidos.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import jakarta.ws.rs.core.MediaType;
import br.com.api_pedidos.api_pedidos.model.dto.PedidosDto;
import br.com.api_pedidos.api_pedidos.service.PedidosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/pedidos",
        produces = MediaType.APPLICATION_JSON,
        consumes = MediaType.APPLICATION_JSON
)
public class PedidosController {

    public final PedidosService pedidosService;

    //metodos get: 
    //1) getAll
    @GetMapping
    public ResponseEntity<Page<PedidosDto>> findAll(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(pedidosService.findAll(pagination));
    }

    //2)getById
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidosService.findById(id));
    }

    //Metodo post:
    @PostMapping
    public ResponseEntity<PedidosDto> save(@RequestBody @Valid PedidosDto pedidosDto) {
        return ResponseEntity.status(201).body(pedidosService.save(pedidosDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosDto> update(@PathVariable Long id, @RequestBody @Valid PedidosDto pedidosDto) {
        return ResponseEntity.ok(pedidosService.update(id, pedidosDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pedidosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
