package com.fiap.carcheap.controller;

import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.enums.UserPerfis;
import com.fiap.carcheap.exception.PerfilInvalidoException;
import com.fiap.carcheap.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pedido")
@RestController
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscaPedidos(
            @RequestHeader final String perfil
    ) {
        if (!UserPerfis.isVendedor(perfil)) throw new PerfilInvalidoException();
        return ResponseEntity.ok(service.buscaPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscaPedido(
            @RequestHeader final String perfil,
            @PathVariable final Long id
    ) {
        if (!UserPerfis.isVendedor(perfil)) throw new PerfilInvalidoException();
        return ResponseEntity.ok(service.buscaPedido(id));
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criaPedidoVenda(
            @RequestHeader final String perfil,
            @RequestBody final PedidoRequest request
    ) {
        if (!UserPerfis.isVendedor(perfil)) throw new PerfilInvalidoException();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criaPedido(request));
    }

    @PostMapping("/{id}")
    public ResponseEntity<PedidoResponse> pagaPedidoVenda(
            @PathVariable final Long id
    ) {
        return ResponseEntity.ok(service.pagaPedido(id));
    }
}
