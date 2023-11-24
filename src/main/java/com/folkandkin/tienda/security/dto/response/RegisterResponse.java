package com.folkandkin.tienda.security.dto.response;

import com.folkandkin.tienda.dto.response.StoreResponse;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Registro.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class RegisterResponse {
    private String email;
    private String token;
    private StoreResponse store;
}
