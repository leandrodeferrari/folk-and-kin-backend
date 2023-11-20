package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para la Tienda.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class StoreResponse {
    private Long id;
    private String name;
    private String logoURL;
}
