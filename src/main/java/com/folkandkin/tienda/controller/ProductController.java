package com.folkandkin.tienda.controller;

import com.folkandkin.tienda.dto.response.ProductResponse;
import com.folkandkin.tienda.service.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase del controlador de presentacion de Producto, que devuelve un JSON al
 * cliente.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Productos")
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Operation(description = "Obtener todos los productos. Rol: ADMIN. Parámetros: Ninguno.")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok().body(this.productService.findAll());
    }
}
