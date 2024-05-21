package com.fiap.carcheap.repository;

import com.fiap.carcheap.repository.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
