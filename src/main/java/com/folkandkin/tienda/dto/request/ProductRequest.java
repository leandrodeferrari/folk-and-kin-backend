package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
public class ProductRequest {
    @NotNull(message = "El nombre del producto no puede ser nulo.")
    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    private String name;

    @NotNull(message = "La descripción del producto no puede ser nulo.")
    @NotBlank(message = "La descripción del producto no puede estar vacío.")
    private String description;

    @NotNull(message = "El precio del producto no puede ser nulo.")
    @NotBlank(message = "El precio del producto no puede estar vacío.")
    private String price;

    @Min(message = "El stock no puede ser menor a 0", value = 0)
    private Integer stock;

    @NotNull(message = "El ID de la tienda no puede ser nulo.")
    @Min(message = "El ID de la tienda no puede ser menor a 1.", value = 1)
    private Long storeId;

    @NotNull(message = "Los IDs de las categorías no pueden ser nulos.")
    private List<Integer> categoriesId;

    private List<ColorProductRequest> colorsId;

    private List<ColorProductRequest> sizesId;

}
