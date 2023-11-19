package com.folkandkin.tienda.service;

import com.folkandkin.tienda.dto.response.SizeResponse;

import java.util.List;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Talle.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

public interface ISizeService {
    List<SizeResponse> findAll();
}
