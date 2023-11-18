package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Color.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class ColorResponse {
    private Integer id;
    private String name;
    private String hexadecimalCode;
}
