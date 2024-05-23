package com.fiap.carcheap.repository.entity;

import com.fiap.carcheap.enums.UserPerfis;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @OneToMany(mappedBy = TROCAR, cascade = CascadeType.ALL)
    private ArrayList<Pedido> pedidos;
}
