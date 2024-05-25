package com.fiap.carcheap.repository;

import com.fiap.carcheap.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
