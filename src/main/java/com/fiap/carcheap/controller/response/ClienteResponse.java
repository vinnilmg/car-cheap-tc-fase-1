package com.fiap.carcheap.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String rg;
}
