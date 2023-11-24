package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.SizeProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase de acceso a datos para el objeto de dominio TalleProducto.
 * Tabla intermedia entre Talle y Producto.
 *
 * @version v1 14 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface ISizeProductRepository extends JpaRepository<SizeProduct, Long> {
}
