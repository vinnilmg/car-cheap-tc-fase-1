package com.fiap.carcheap.repository.entity.enums;

import lombok.Getter;

@Getter
public enum ComissaoEnum {
    ECONOMICO(2.5),
    PREMIUM(4.0);

    private final Double valor;


    ComissaoEnum(Double valor) {
        this.valor = valor;
    }
}
