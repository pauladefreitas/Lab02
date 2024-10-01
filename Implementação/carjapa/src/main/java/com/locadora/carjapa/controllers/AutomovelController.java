package com.locadora.carjapa.controllers;

import com.locadora.carjapa.models.Automovel;
import com.locadora.carjapa.services.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/automovel")
public class AutomovelController {

    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/{id}")
    public ResponseEntity<Automovel> findById(@PathVariable Long id) {
        Automovel obj = this.automovelService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Automovel obj) {
        this.automovelService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Automovel obj) {
        obj.setId(id);
        this.automovelService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.automovelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
