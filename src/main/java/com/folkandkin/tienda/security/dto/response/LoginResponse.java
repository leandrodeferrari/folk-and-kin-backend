package com.folkandkin.tienda.security.dto.response;

import com.folkandkin.tienda.dto.response.StoreResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Login.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Data
@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String token;
    private List<StoreResponse> stores;
}
