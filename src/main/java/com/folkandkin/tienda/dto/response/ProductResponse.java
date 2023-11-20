package com.folkandkin.tienda.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Clase que representa la respuesta envidada para el Cliente, para el Producto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String price;
    private Integer stock;
    private StoreResponse store;
    private List<PhotoResponse> photos;
    private List<CategoryResponse> categories;
    private List<ColorProductResponse> colors;
    private List<SizeProductResponse> sizes;
}
