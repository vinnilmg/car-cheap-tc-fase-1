package com.fiap.carcheap.controller.mapper;

import com.fiap.carcheap.controller.response.PedidoResponse;
import com.fiap.carcheap.repository.entity.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoResponseMapper {
    PedidoResponse toPedidoResponse(Pedido pedido);
}
