package com.folkandkin.tienda.security.controller;

import com.folkandkin.tienda.security.dto.request.ForgotPasswordRequest;
import com.folkandkin.tienda.security.dto.response.ForgotPasswordResponse;
import com.folkandkin.tienda.security.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Clase del controlador de presentacion de Usuario, que devuelve un JSON al
 * cliente.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(description = "Cambiar contraseña de Usuario. Rol: Autenticado. Parámetros: String oldPassword, String newPassword.")
    @PatchMapping("/forgot-password")
    public ResponseEntity<ForgotPasswordResponse> resetPassword(@Valid @RequestBody ForgotPasswordRequest request){
        return ResponseEntity.ok(this.userService.resetPassword(request));
    }
}
