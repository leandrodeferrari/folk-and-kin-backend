package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Clase de objeto de dominio, que representa la tabla intermedia entre Color y Producto.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "colores_productos", uniqueConstraints =
    @UniqueConstraint(columnNames = {"producto_id", "color_id"}))
public class ColorProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
}
