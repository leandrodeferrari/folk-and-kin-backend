package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase de acceso a datos para el objeto de dominio Talle.
 *
 * @version v1 14 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface ISizeRepository extends JpaRepository<Size, Integer> {
    boolean existsByName(String name);
    Optional<Size> findByName(String name);
}