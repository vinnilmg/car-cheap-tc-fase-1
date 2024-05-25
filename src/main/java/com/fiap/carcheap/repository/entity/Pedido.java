package com.fiap.carcheap.repository.entity;

import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User vendedor;

    @OneToOne
    private Carro carro;

    @ManyToOne
    private Cliente cliente;

    private BigDecimal valorComissao;

    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum statusPedido;

    public static BigDecimal calculaComissao(Double porcentagemComissao, Long valorVenda) {
        return BigDecimal.valueOf((porcentagemComissao * valorVenda) / 100);
    }
}
