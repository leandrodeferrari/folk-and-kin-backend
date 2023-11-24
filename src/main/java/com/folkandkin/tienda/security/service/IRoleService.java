package com.folkandkin.tienda.security.service;

import com.folkandkin.tienda.security.domain.entity.Role;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Rol.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

public interface IRoleService {
    Role findByName(String name);
}
