package com.fiap.carcheap.repository.entity.enums;

import java.util.Arrays;

public enum TipoPagamentoEnum {
    PIX,
    FINANCIAMENTO,
    DINHEIRO,
    CREDITO,
    DEBITO;

    public static TipoPagamentoEnum toEnum(final String value) {
        return Arrays.stream(values())
                .filter(tp -> tp.name().equals(value.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
