package com.fiap.carcheap.controller;

import com.fiap.carcheap.controller.request.CarroUpdateRequest;
import com.fiap.carcheap.repository.entity.Carro;
import com.fiap.carcheap.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<Collection<Carro>> findAll() {
        var carros = service.findAll();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> findById(@PathVariable String id) {
        var carro = service.findById(id);
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody Carro carro) {
        carro = service.save(carro);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> update(@PathVariable String id, @RequestBody CarroUpdateRequest carro) {
       return ResponseEntity.ok(service.update(id, carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
