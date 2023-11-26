package com.folkandkin.tienda.security.service;

import com.folkandkin.tienda.security.dto.request.ChangePasswordRequest;
import com.folkandkin.tienda.security.dto.response.ChangePasswordResponse;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Usuario.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

public interface IUserService {
    ChangePasswordResponse changePassword(ChangePasswordRequest request);
}
