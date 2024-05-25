package com.fiap.carcheap.controller.request;

import com.fiap.carcheap.repository.entity.User;
import com.fiap.carcheap.repository.entity.enums.UserPerfis;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
    private String nome;
    private String sobrenome;
    private UserPerfis perfil;

    public static User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setNome(userRequest.getNome());
        user.setSobrenome(userRequest.getSobrenome());
        user.setPerfil(userRequest.getPerfil());
        return user;
    }
}
