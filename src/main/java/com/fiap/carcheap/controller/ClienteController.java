package com.fiap.carcheap.controller;

import com.fiap.carcheap.dto.ClienteDto;
import com.fiap.carcheap.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping(value = "/listAll")
    public List<ClienteDto> findAll(){
        return clienteService.buscarTodos();
    }
}
