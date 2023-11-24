package com.folkandkin.tienda.security.service.impl;

import com.folkandkin.tienda.exception.RoleNameNotNullException;
import com.folkandkin.tienda.security.domain.entity.Role;
import com.folkandkin.tienda.security.repository.IRoleRepository;
import com.folkandkin.tienda.security.service.IRoleService;

import org.springframework.stereotype.Service;

/**
 * Clase de objeto de negocio del objeto de dominio Rol.
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Service
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        this.validName(name);

        return this.roleRepository.findByName(name).orElseThrow();
    }

    private void validName(String name){
        if(name == null){
            throw new RoleNameNotNullException("El nombre del Rol no puede ser nulo.");
        }

        if(name.isBlank()){
            throw new RoleNameNotNullException("El nombre del Rol no puede estar vacío.");
        }
    }
}
