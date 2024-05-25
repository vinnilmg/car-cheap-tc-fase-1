package com.fiap.carcheap.controller.mapper;

import com.fiap.carcheap.controller.response.ClienteResponse;
import com.fiap.carcheap.repository.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteResponseMapper {
    ClienteResponse toClienteResponse(Cliente cliente);
}
