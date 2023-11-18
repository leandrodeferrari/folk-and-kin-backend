package com.folkandkin.tienda.service;

import com.folkandkin.tienda.dto.request.ColorRequest;
import com.folkandkin.tienda.dto.response.ColorResponse;

import java.util.List;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Color.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

public interface IColorService {
    List<ColorResponse> findAll();
    ColorResponse save(ColorRequest request);
}
