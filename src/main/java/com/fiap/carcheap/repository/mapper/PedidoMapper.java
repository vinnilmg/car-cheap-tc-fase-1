package com.fiap.carcheap.repository.mapper;

import com.fiap.carcheap.controller.request.PedidoRequest;
import com.fiap.carcheap.repository.entity.Carro;
import com.fiap.carcheap.repository.entity.Pedido;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", imports = {BigDecimal.class})
public interface PedidoMapper {

    @Mapping(target = "carro", source = "carro")
    @Mapping(target = "tipoPagamento", source = "request.tipoPagamento", qualifiedByName = "mapTipoPagamento")
    @Mapping(target = "valorComissao", expression = "java(new BigDecimal(\"1000.00\"))") // TODO: Precisa da entidade para calcular
    Pedido toPedido(PedidoRequest request, Carro carro);

    @Named("mapTipoPagamento")
    default TipoPagamentoEnum mapTipoPagamento(final String tipoPagamento) {
        return TipoPagamentoEnum.toEnum(tipoPagamento);
    }
}
