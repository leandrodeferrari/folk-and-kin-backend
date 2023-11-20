package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Color/Producto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class ColorProductResponse {
    private Long id;
    private Integer stock;
    private ColorResponse color;
}
