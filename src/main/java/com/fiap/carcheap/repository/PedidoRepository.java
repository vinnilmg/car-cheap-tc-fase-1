package com.fiap.carcheap.repository;

import com.fiap.carcheap.repository.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    boolean existsByCarroId(UUID id);
}
