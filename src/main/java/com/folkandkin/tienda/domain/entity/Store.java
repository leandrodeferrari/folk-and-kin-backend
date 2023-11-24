package com.folkandkin.tienda.domain.entity;

import com.folkandkin.tienda.security.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Clase de objeto de dominio Tienda.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "tiendas")
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 20, name = "nombre", nullable = false)
    private String name;

    @Column(name = "logo_url")
    private String logoURL;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;
}
