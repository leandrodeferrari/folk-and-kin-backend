package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Color;
import com.folkandkin.tienda.dto.request.ColorRequest;
import com.folkandkin.tienda.dto.response.ColorResponse;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Color.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

public interface IColorService {
    Optional<Color> findById(Integer id);
    List<ColorResponse> findAll();
    ColorResponse save(ColorRequest request);
    Optional<Color> findByName(String colorName);
}
