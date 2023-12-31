package com.folkandkin.tienda.service;

import com.folkandkin.tienda.domain.entity.Category;
import com.folkandkin.tienda.dto.request.CategoryRequest;
import com.folkandkin.tienda.dto.response.CategoryResponse;

import java.util.List;

/**
 * Interfaz para que implemente el objeto de negocio del objeto de dominio Categoria.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

public interface ICategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse save(CategoryRequest request);
    List<Category> findAllById(List<Integer> categoriesId);
}
