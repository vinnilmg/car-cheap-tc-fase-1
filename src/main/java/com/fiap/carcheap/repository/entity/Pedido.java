package com.fiap.carcheap.repository.entity;

import com.fiap.carcheap.repository.entity.enums.StatusPedidoEnum;
import com.fiap.carcheap.repository.entity.enums.TipoPagamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendedor; // TODO: Precisa da entidade de usuarios

    @OneToOne
    private Carro carro;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    private BigDecimal valorComissao;

    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum statusPedido;
}
