package com.folkandkin.tienda.security.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Clase de objeto de dominio Usuario.
 *
 * @version v1 12 Nov 2023
 * @author Leandro Deferrari
 */

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50, name = "nombre_de_usuario", nullable = false)
    private String username;

    @Column(name = "contrasenia", nullable = false)
    private String password;

    @Column(length = 50, name = "email", nullable = false)
    private String email;

    @Column(length = 15, name = "telefono")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Role role;
}
