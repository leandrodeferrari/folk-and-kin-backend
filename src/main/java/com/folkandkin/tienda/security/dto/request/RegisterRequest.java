package com.folkandkin.tienda.security.dto.request;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * Clase que representa la solicitud envidada por el Cliente, para el Registro.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class RegisterRequest {
    @NotNull(message = "El nombre de usuario no puede ser nulo.")
    @NotBlank(message = "El nombre de usuario no puede estar vacío.")
    private String username;

    @NotNull(message = "El email no puede ser nulo.")
    @NotBlank(message = "El email no puede estar vacío.")
    @Email(message = "El email ingresado no es válido.")
    private String email;

    @NotNull(message = "La contraseña no puede ser nula.")
    @NotBlank(message = "La contraseña no puede estar vacía.")
    @Size(min = 8, message = "La contraseña no puede tener menos de 8 caracteres.")
    private String password;

    private String phone;
}
