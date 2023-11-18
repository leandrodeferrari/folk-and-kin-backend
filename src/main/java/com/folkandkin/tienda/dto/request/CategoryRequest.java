package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryRequest {
    @NotNull(message = "El nombre de la categoría no puede ser nula.")
    @NotBlank(message = "El nombre de la categoría no puede estar vacía.")
    private String name;
}
