package com.fiap.carcheap.controller;

import com.fiap.carcheap.controller.mapper.ClienteResponseMapper;
import com.fiap.carcheap.controller.response.ClienteResponse;
import com.fiap.carcheap.dto.ClienteDto;
import com.fiap.carcheap.service.ClienteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteResponseMapper clienteResponseMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obterPorId(@PathVariable @NotNull String id) {
        return ResponseEntity.ok(clienteService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvarCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto clienteDto1 = clienteService.salvarCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDto> deletarCliente(@PathVariable String id) {
        clienteService.deleltarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable UUID id, @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteAtualizado = clienteService.atualizarCliente(id, clienteDto);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
