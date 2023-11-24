package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Clase de objeto de dominio, que representa la tabla intermedia entre Talle y Producto.
 *
 * @version v1 14 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "talles_productos", uniqueConstraints =
@UniqueConstraint(columnNames = {"producto_id", "talle_id"}))
public class SizeProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "talle_id", nullable = false)
    private Size size;
}
