package com.locadora.carjapa.controllers;

import com.locadora.carjapa.models.Rendimento;
import com.locadora.carjapa.services.RendimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/rendimento")
public class RendimentoController {
    @Autowired
    private RendimentoService rendimentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Rendimento> findById(@PathVariable Long id) {
        Rendimento obj = this.rendimentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Rendimento obj) {
        this.rendimentoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Rendimento obj, @PathVariable Long id) {
        obj.setId(id);
        this.rendimentoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.rendimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
