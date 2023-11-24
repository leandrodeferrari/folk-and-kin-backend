package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de objeto de dominio Categoria.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "categorias")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 30, name = "nombre", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Product> products;
}
