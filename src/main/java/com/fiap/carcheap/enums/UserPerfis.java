package com.fiap.carcheap.enums;

public enum UserPerfis {
    MASTER,
    VENDEDOR;

    public static boolean isVendedor(final String perfil) {
        return VENDEDOR.name().equalsIgnoreCase(perfil);
    }
}
