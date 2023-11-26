package com.folkandkin.tienda.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el cambio de contraseña.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@AllArgsConstructor
@Data
public class ChangePasswordResponse {
    private String message;
}
