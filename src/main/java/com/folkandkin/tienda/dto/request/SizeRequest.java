package com.folkandkin.tienda.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SizeRequest {
    @NotNull(message = "El nombre del talle no puede ser nulo.")
    @NotBlank(message = "El nombre del talle no puede estar vacío.")
    private String name;
}
