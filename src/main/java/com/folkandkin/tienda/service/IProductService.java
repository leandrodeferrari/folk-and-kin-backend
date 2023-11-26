package com.folkandkin.tienda.service;

import com.folkandkin.tienda.dto.request.ProductRequest;
import com.folkandkin.tienda.dto.response.PhotoResponse;
import com.folkandkin.tienda.dto.response.ProductResponse;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Producto.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

public interface IProductService {
    List<ProductResponse> findAll();
    List<ProductResponse> findAllByStoreId(Long storeId);
    ProductResponse save(ProductRequest request);
    PhotoResponse savePhoto(MultipartFile photo, Long productId);
}
