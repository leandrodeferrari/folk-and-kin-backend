package com.folkandkin.tienda.controller;

import com.folkandkin.tienda.dto.request.CategoryRequest;
import com.folkandkin.tienda.dto.response.CategoryResponse;
import com.folkandkin.tienda.service.ICategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

/**
 * Clase del controlador de presentacion de Categoria, que devuelve un JSON al
 * cliente.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Categorías")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(description = "Obtener todas las categorías. Rol: ADMIN. Parámetros: Ninguno.")
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.ok().body(this.categoryService.findAll());
    }

    @Operation(description = "Crear una categoría. Rol: ADMIN. Parámetros: String name.")
    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request){
        return ResponseEntity.ok().body(this.categoryService.save(request));
    }
}
