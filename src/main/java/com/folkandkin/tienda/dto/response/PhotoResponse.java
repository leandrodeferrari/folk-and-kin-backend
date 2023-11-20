package com.folkandkin.tienda.dto.response;

import lombok.Data;

/**
 * Clase que representa la respuesta envidada para el Cliente, para la Foto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class PhotoResponse {
    private Long id;
    private String url;
}
