package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Talle.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class SizeResponse {
    private Integer id;
    private String name;
    private String standard;
}
