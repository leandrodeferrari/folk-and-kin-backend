package com.folkandkin.tienda.controller;

import com.folkandkin.tienda.dto.request.ColorRequest;
import com.folkandkin.tienda.dto.response.ColorResponse;
import com.folkandkin.tienda.service.IColorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * Clase del controlador de presentacion de Color, que devuelve un JSON al
 * cliente.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Colores")
@RestController
@RequestMapping("/colors")
public class ColorController {
    private final IColorService colorService;

    public ColorController(IColorService colorService) {
        this.colorService = colorService;
    }

    @Operation(description = "Obtener todos las colores. Rol: ADMIN. Parámetros: Ninguno.")
    @GetMapping
    public ResponseEntity<List<ColorResponse>> findAll(){
        return ResponseEntity.ok().body(this.colorService.findAll());
    }

    @Operation(description = "Crear un color. Rol: ADMIN. Parámetros: String name, String hexadecimalCode.")
    @PostMapping
    public ResponseEntity<ColorResponse> save(@Valid @RequestBody ColorRequest request){
        return ResponseEntity.ok().body(this.colorService.save(request));
    }
}
