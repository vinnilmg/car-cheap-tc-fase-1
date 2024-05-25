package com.fiap.carcheap.controller.mapper;

import com.fiap.carcheap.controller.response.ClienteResponse;
import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.controller.response.UserResponse;
import com.fiap.carcheap.repository.entity.Cliente;
import com.fiap.carcheap.repository.entity.Pedido;
import com.fiap.carcheap.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoResponseMapper {

    @Mapping(target = "vendedor", source = "vendedor", qualifiedByName = "mapVendedor")
    @Mapping(target = "cliente", source = "cliente", qualifiedByName = "mapCliente")
    PedidoResponse toPedidoResponse(Pedido pedido);

    @Named("mapVendedor")
    default UserResponse mapVendedor(User user) {
        return Mappers.getMapper(UserResponseMapper.class).toUserResponse(user);
    }

    @Named("mapCliente")
    default ClienteResponse mapCliente(Cliente cliente) {
        return Mappers.getMapper(ClienteResponseMapper.class).toClienteResponse(cliente);
    }
}
