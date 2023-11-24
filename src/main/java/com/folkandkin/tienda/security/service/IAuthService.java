package com.folkandkin.tienda.security.service;

import com.folkandkin.tienda.security.dto.request.LoginRequest;
import com.folkandkin.tienda.security.dto.request.RegisterRequest;
import com.folkandkin.tienda.security.dto.response.LoginResponse;
import com.folkandkin.tienda.security.dto.response.LogoutResponse;
import com.folkandkin.tienda.security.dto.response.RegisterResponse;

/**
 * Interfaz para que implemente el objeto de negocio de Auth.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

public interface IAuthService {
    LoginResponse login(LoginRequest request);
    RegisterResponse register(RegisterRequest request);
    LogoutResponse logout();
}
