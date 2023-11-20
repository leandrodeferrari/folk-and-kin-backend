package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.ColorProduct;
import com.folkandkin.tienda.dto.response.ColorProductResponse;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * Interfaz mapeadora para Color/Producto. Utilizando la librería MapStruct.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring",
        uses = {IColorMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IColorProductMapper {
    ColorProductResponse mapToDto(ColorProduct entity);
}
