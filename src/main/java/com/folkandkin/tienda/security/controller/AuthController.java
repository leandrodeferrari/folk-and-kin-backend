package com.folkandkin.tienda.security.controller;

import com.folkandkin.tienda.security.dto.request.LoginRequest;
import com.folkandkin.tienda.security.dto.request.RegisterRequest;
import com.folkandkin.tienda.security.dto.response.LoginResponse;
import com.folkandkin.tienda.security.dto.response.RegisterResponse;
import com.folkandkin.tienda.security.service.IAuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Clase del controlador de presentacion de Autenticación, que devuelve un JSON al
 * cliente.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Autenticación")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService){
        this.authService = authService;
    }

    @Operation(description = "Autenticar Usuario. Rol: ADMIN. Parámetros: String email, String password.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok().body(this.authService.login(request));
    }

    @Operation(description = "Registrar Usuario. Rol: Sin rol. Parámetros: String username, String email, String password, String phone (Opcional).")
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> login(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok().body(this.authService.register(request));
    }
}
