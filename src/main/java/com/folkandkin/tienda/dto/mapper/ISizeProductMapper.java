package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.SizeProduct;
import com.folkandkin.tienda.dto.response.SizeProductResponse;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * Interfaz mapeadora para Talle/Producto. Utilizando la librería MapStruct.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring",
        uses = {ISizeMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ISizeProductMapper {
    SizeProductResponse mapToDto(SizeProduct entity);
}
