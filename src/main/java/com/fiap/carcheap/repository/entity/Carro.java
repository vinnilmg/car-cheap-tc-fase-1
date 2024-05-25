package com.fiap.carcheap.repository.entity;

import com.fiap.carcheap.repository.entity.enums.ClassificacaoCarroEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long anofab;
    @NotNull
    private Long anomodelo;
    @NotNull
    private Long potencia;
    @NotBlank
    private String cor;
    @NotNull
    private Long nr_portas;
    @NotBlank
    private String equipamentos;
    private String tp_carroceria;
    @NotNull
    private Long vr_original;
    @NotNull
    private Long vr_venda;
    private String origem;
    private String status;
    @Enumerated(EnumType.STRING)
    private ClassificacaoCarroEnum classificacao;
}
