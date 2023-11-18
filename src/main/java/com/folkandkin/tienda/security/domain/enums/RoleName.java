package com.folkandkin.tienda.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum de los nombres de los roles, de la clase de dominio Rol.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@AllArgsConstructor
@Getter
public enum RoleName {
    ADMIN("ADMIN");

    private final String name;
}
