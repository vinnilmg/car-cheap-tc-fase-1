package com.fiap.carcheap.repository.entity;


import com.fiap.carcheap.repository.entity.enums.UserPerfis;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String username;
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @Enumerated(EnumType.STRING)
    private UserPerfis perfil;
}
