package com.fiap.carcheap.controller.response;

import com.fiap.carcheap.repository.entity.enums.UserPerfis;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponse {
    private UUID id;
    private String username;
    private String nome;
    private String sobrenome;
    private UserPerfis perfil;
}
