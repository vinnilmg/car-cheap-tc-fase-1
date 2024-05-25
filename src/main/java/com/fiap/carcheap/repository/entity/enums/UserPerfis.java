package com.fiap.carcheap.repository.entity.enums;

public enum UserPerfis {
    MASTER,
    VENDEDOR;

    public static boolean isVendedor(final String perfil) {
        return VENDEDOR.name().equalsIgnoreCase(perfil);
    }
}
