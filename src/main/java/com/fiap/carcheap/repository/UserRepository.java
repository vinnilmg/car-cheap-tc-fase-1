package com.fiap.carcheap.repository;

import com.fiap.carcheap.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
