package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SizeProductRequest {
    @NotNull(message = "El stock del talle del producto no puede ser nulo.")
    @Min(message = "El stock del talle del producto no puede ser menor a 0", value = 0)
    private Integer stock;

    @Min(message = "El ID del talle del producto no puede ser menor a 1", value = 1)
    private Integer sizeId;
}
