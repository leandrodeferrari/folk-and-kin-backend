package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Category;
import com.folkandkin.tienda.dto.request.CategoryRequest;
import com.folkandkin.tienda.dto.response.CategoryResponse;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz mapeadora para la Categoria. Utilizando la librería MapStruct.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    Category mapToEntity(CategoryRequest dto);
    CategoryResponse mapToDto(Category entity);
    List<CategoryResponse> mapToDto(List<Category> entities);
}
