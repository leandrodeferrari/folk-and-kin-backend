package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.Color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase de acceso a datos para el objeto de dominio Color.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface IColorRepository extends JpaRepository<Color, Integer> {
    Optional<Color> findByName(String name);
}