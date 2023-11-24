package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Size;
import com.folkandkin.tienda.dto.request.SizeRequest;
import com.folkandkin.tienda.dto.response.SizeResponse;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Talle.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

public interface ISizeService {
    List<SizeResponse> findAll();
    SizeResponse save(SizeRequest request);
    Optional<Size> findById(Integer sizeId);
}
