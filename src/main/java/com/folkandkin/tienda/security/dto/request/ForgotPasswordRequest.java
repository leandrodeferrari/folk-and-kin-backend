package com.folkandkin.tienda.security.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa la solicitud envidada por el Cliente, para el cambio de contraseña.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class ForgotPasswordRequest {
    @NotNull(message = "La contraseña antigua no puede ser nula.")
    @NotBlank(message = "La contraseña antigua no puede estar vacía.")
    @Size(min = 8, message = "La contraseña antigua no puede tener menos de 8 caracteres.")
    private String oldPassword;

    @NotNull(message = "La contraseña nueva no puede ser nula.")
    @NotBlank(message = "La contraseña nueva no puede estar vacía.")
    @Size(min = 8, message = "La contraseña nueva no puede tener menos de 8 caracteres.")
    private String newPassword;
}
