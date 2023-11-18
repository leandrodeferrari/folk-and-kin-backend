package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ColorRequest {
    @NotNull(message = "El nombre del color no puede ser nulo.")
    @NotBlank(message = "El nombre del color no puede estar vacío.")
    private String name;

    @NotNull(message = "El código hexadecimal del color no puede ser nulo.")
    @NotBlank(message = "El código hexadecimal del color no puede estar vacío.")
    private String hexadecimalCode;
}
