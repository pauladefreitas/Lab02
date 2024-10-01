package com.locadora.carjapa.controllers;

import com.locadora.carjapa.models.Empregador;
import com.locadora.carjapa.services.EmpregadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/empregador")
public class EmpregadorController {
    @Autowired
    private EmpregadorService empregadorService;

    @GetMapping("/{id}")
    public ResponseEntity<Empregador> findById(@PathVariable Long id) {
        Empregador obj = this.empregadorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Empregador obj) {
        this.empregadorService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Empregador obj, @PathVariable Long id) {
        obj.setId(id);
        this.empregadorService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.empregadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
