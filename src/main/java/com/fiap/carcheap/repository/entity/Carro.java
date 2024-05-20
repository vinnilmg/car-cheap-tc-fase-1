package com.fiap.carcheap.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String placa;
    @NotBlank
    private String chassi;
    @NotBlank
    private String renavan;
    @NotBlank
    private Long anofab;
    @NotBlank
    private Long anomodelo;
    @NotBlank
    private Long potencia;
    @NotBlank
    private String cor;
    @NotBlank
    private Long nr_portas;
    @NotBlank
    private String equipamentos;
    private String tp_carroceria;
    @NotBlank
    private Long vr_original;
    @NotBlank
    private Long vr_venda;
    private String origem;
    private String status;
}
