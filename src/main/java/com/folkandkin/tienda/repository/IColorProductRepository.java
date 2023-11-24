package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.ColorProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase de acceso a datos para el objeto de dominio ColorProducto.
 * Tabla intermedia entre Color y Producto.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface IColorProductRepository extends JpaRepository<ColorProduct, Long> {
}
