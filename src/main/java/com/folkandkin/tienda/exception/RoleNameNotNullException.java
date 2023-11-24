package com.folkandkin.tienda.exception;

/**
 * Excepción personalizada para cuando el nombre del rol es nulo.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

public class RoleNameNotNullException extends RuntimeException {
    public RoleNameNotNullException(String message) {
        super(message);
    }
}
