package com.fiap.carcheap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String rg;
}
