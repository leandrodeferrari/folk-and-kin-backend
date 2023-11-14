package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase de objeto de dominio Producto.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "productos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 100, name = "nombre", nullable = false)
    private String name;

    @Column(length = 1500, name = "descripcion", nullable = false)
    private String description;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private Store store;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Photo> photos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categorias_productos",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"producto_id", "categoria_id"}))
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ColorProduct> colors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<SizeProduct> sizes;
}
