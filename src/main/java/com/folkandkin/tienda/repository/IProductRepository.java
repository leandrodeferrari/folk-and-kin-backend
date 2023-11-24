package com.folkandkin.tienda.repository;

import com.folkandkin.tienda.domain.entity.Product;
import com.folkandkin.tienda.domain.entity.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase de acceso a datos para el objeto de dominio Producto.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStore(Store store);
}
