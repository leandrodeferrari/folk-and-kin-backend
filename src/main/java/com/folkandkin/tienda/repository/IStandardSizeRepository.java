package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.StandardSize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase de acceso a datos para el objeto de dominio Estandar de Talle.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface IStandardSizeRepository extends JpaRepository<StandardSize, Integer> {
    Optional<StandardSize> findByName(String name);
}
