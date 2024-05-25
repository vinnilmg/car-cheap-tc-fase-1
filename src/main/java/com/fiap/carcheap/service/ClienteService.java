package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.mapper.ClienteResponseMapper;
import com.fiap.carcheap.controller.response.ClienteResponse;
import com.fiap.carcheap.dto.ClienteDto;
import com.fiap.carcheap.exception.ClienteNotFoundException;
import com.fiap.carcheap.repository.ClienteRepository;
import com.fiap.carcheap.repository.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteResponseMapper clienteResponseMapper;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClienteResponse> buscarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteResponseMapper::toClienteResponse)
                .toList();
    }

    public ClienteResponse obterPorId(Long id) {
        return getById(id)
                .map(clienteResponseMapper::toClienteResponse)
                .orElseThrow(ClienteNotFoundException::new);
    }

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteDto salvarCliente(ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public void deleltarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDto atualizarCliente(Long id, ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        cliente.setId(id);
        cliente = clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDto.class);
    }
}
