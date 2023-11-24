package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Talle/Producto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class SizeProductResponse {
    private Long id;
    private Integer stock;
    private SizeResponse size;
}
