package com.folkandkin.tienda.security.repository;

import com.folkandkin.tienda.security.domain.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase de acceso a datos para el objeto de dominio Rol.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface IRoleRepository extends JpaRepository<Role, Byte> {
    Optional<Role> findByName(String name);
}
