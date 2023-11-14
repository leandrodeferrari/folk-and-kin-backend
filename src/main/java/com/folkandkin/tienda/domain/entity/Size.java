package com.folkandkin.tienda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de objeto de dominio Talle.
 *
 * @version v1 14 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "talles")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 20, name = "nombre", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "estandar_id", nullable = false)
    private StandardSize standard;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
    private List<SizeProduct> products;
}
