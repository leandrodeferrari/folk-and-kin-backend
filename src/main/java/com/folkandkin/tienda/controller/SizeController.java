package com.folkandkin.tienda.controller;

import com.folkandkin.tienda.dto.request.SizeRequest;
import com.folkandkin.tienda.dto.response.SizeResponse;
import com.folkandkin.tienda.service.ISizeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * Clase del controlador de presentacion de Talle, que devuelve un JSON al
 * cliente.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Talles")
@RestController
@RequestMapping("/sizes")
public class SizeController {
    private final ISizeService sizeService;

    public SizeController(ISizeService sizeService) {
        this.sizeService = sizeService;
    }

    @Operation(description = "Obtener todos los talles. Rol: ADMIN. Parámetros: Ninguno.")
    @GetMapping
    public ResponseEntity<List<SizeResponse>> findAll(){
        return ResponseEntity.ok().body(this.sizeService.findAll());
    }

    @Operation(description = "Crear un talle. Rol: ADMIN. Parámetros: String name.")
    @PostMapping
    public ResponseEntity<SizeResponse> save(@Valid @RequestBody SizeRequest request){
        return ResponseEntity.ok().body(this.sizeService.save(request));
    }
}
