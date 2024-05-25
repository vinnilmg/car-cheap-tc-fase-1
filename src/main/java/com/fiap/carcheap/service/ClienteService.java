package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.mapper.ClienteResponseMapper;
import com.fiap.carcheap.controller.request.ClienteRequest;
import com.fiap.carcheap.controller.response.ClienteResponse;
import com.fiap.carcheap.dto.ClienteDto;
import com.fiap.carcheap.repository.ClienteRepository;
import com.fiap.carcheap.repository.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteResponseMapper clienteResponseMapper;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClienteResponse> buscarTodos(){

        return clienteRepository.findAll().stream().map(clienteResponseMapper::toClienteResponse).toList();
    }

    public ClienteResponse obterPorId(Long id){
       try {
           return clienteRepository
                   .findById(id).map(clienteResponseMapper::toClienteResponse).orElseThrow(Exception::new);
       }catch (Exception e){
           e.getMessage();
       }
       return null;
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
