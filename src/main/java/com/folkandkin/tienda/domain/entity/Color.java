package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de objeto de dominio Color.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "colores")
public class Color implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 20, name = "nombre", nullable = false, unique = true)
    private String name;

    @Column(length = 7, name = "codigo_hexadecimal", nullable = false, unique = true)
    private String hexadecimalCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private List<ColorProduct> products;
}
