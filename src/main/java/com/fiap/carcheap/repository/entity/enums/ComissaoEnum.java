package com.fiap.carcheap.repository.entity.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ComissaoEnum {
    ECONOMICO(2.5),
    PREMIUM(4.0);

    private final Double valor;

    ComissaoEnum(Double valor) {
        this.valor = valor;
    }

    public static ComissaoEnum getComissaoByName(final ClassificacaoCarroEnum classificacao) {
        return Arrays.stream(values())
                .filter(value -> value.name().equalsIgnoreCase(classificacao.name()))
                .findFirst()
                .orElse(null);
    }
}
