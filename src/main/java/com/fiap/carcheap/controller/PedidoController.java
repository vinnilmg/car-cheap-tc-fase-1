package com.fiap.carcheap.controller;

import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/pedido")
@RestController
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscaPedidos(
            @RequestHeader final String perfil
    ) {
        return ResponseEntity.ok(service.buscaPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscaPedido(
            @RequestHeader final String perfil,
            @PathVariable final Long id
    ) {
        return ResponseEntity.ok(service.buscaPedido(id));
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criaPedidoVenda(
            @RequestHeader final String perfil
    ) {
        log.info("Criando pedido de venda...");
        service.criaPedido();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(null); // TODO: Precisa retornar o objeto criado
    }
}
