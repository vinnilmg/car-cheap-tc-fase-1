package com.fiap.carcheap.service;

import com.fiap.carcheap.dto.ClienteDto;
import com.fiap.carcheap.repository.ClienteRepository;
import com.fiap.carcheap.repository.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public List<ClienteDto> buscarTodos(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> new ClienteDto(cliente.getId(),cliente.getNome(), cliente.getRg(), cliente.getCpf(), cliente.getEmail())).collect(Collectors.toList());
    }
}
