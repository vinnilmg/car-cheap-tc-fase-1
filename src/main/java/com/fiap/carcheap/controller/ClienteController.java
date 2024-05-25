package com.fiap.carcheap.controller;

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

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obterPorId(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(clienteService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvarCliente(@RequestBody ClienteDto clienteDto){
        ClienteDto clienteDto1 = clienteService.salvarCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDto> deletarCliente(@PathVariable Long id){
        clienteService.deleltarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto){
        ClienteDto clienteAtualizado = clienteService.atualizarCliente(id, clienteDto);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
