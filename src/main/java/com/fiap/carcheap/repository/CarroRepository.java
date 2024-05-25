package com.fiap.carcheap.repository;

import com.fiap.carcheap.repository.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarroRepository extends JpaRepository<Carro, UUID> {
}
