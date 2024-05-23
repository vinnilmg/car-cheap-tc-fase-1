package com.fiap.carcheap.repository.mapper;

import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.repository.entity.Cliente;
import com.fiap.carcheap.repository.entity.Pedido;
import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", imports = {BigDecimal.class, Cliente.class, StatusPedidoEnum.class})
public interface PedidoMapper {

    @Mapping(target = "statusPedido", expression = "java(StatusPedidoEnum.PENDENTE)")
    @Mapping(target = "tipoPagamento", source = "tipoPagamento", qualifiedByName = "mapTipoPagamento")
    Pedido toPedido(PedidoRequest request);

    @Named("mapTipoPagamento")
    default TipoPagamentoEnum mapTipoPagamento(final String tipoPagamento) {
        return TipoPagamentoEnum.toEnum(tipoPagamento);
    }
}
