package com.folkandkin.tienda.controller;

import com.folkandkin.tienda.dto.request.ProductRequest;
import com.folkandkin.tienda.dto.response.ProductResponse;
import com.folkandkin.tienda.service.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @Operation(description = "Obtener todos los productos de una tienda. Rol: ADMIN. Parámetros: StoreId (ID de la tienda, recibido por parámetro).")
    @GetMapping("/{storeId}")
    public ResponseEntity<List<ProductResponse>> findAllByStore(@PathVariable Long storeId){
        return ResponseEntity.ok().body(this.productService.findAllByStoreId(storeId));
    }

    @Operation(description = "Crear un producto. Rol: ADMIN. Parámetros: String name, " +
            "String descripcion, String precio, Integer stock (opcional), " +
            "Long storeId, List<Integer> categoriesId, " +
            "List<{Integer stock, Integer colorId}> colors (opcional), " +
            "List<{Integer stock, Integer sizeId}> sizes (opcional)," +
            "List<MultipartFile> photos.")
    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.save(request));
    }
}
