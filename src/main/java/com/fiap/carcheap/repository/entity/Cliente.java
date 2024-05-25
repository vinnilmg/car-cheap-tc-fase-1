package com.fiap.carcheap.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 10, max = 11)
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Size(min = 9, max = 10)
    @Column(unique = true)
    private String rg;
}
