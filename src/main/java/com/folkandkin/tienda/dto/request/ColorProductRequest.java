package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ColorProductRequest {
    @NotNull(message = "El stock del color del producto no puede ser nulo.")
    @Min(message = "El stock del color del producto no puede ser menor a 0", value = 0)
    private Integer stock;

    @NotNull(message = "El nombre del color del producto no puede ser nulo.")
    @NotBlank(message = "El nombre del color del producto no puede ser vacío.")
    private String colorName;
}
