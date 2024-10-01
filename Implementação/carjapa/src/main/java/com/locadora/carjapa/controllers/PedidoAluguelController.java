package com.locadora.carjapa.controllers;

import com.locadora.carjapa.models.PedidoAluguel;
import com.locadora.carjapa.services.PedidoAluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pedidoAluguel")
public class PedidoAluguelController {
    @Autowired
    private PedidoAluguelService pedidoAluguelService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoAluguel> findById(@PathVariable Long id) {
        PedidoAluguel obj = this.pedidoAluguelService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<PedidoAluguel> create(@RequestBody PedidoAluguel obj) {
        this.pedidoAluguelService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PedidoAluguel obj) {
        obj.setId(id);
        this.pedidoAluguelService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.pedidoAluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
