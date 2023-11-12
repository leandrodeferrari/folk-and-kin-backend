package com.folkandkin.tienda.domain.enums;

import lombok.AllArgsConstructor;

/**
 * Enum de los nombres de los roles, de la clase de dominio Rol.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@AllArgsConstructor
public enum RoleName {
    ADMIN("ADMINISTRADOR");

    private final String name;
}
