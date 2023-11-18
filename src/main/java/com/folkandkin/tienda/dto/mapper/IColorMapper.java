package com.folkandkin.tienda.dto.mapper;

import com.folkandkin.tienda.domain.entity.Color;
import com.folkandkin.tienda.dto.response.ColorResponse;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz mapeadora para el Color. Utilizando la librería MapStruct.
 *
 * @version v1 18 Nov 2023
 * @author Leandro Deferrari
 */

@Mapper(componentModel = "spring")
public interface IColorMapper {
    ColorResponse mapToDto(Color entity);
    List<ColorResponse> mapToDto(List<Color> entities);
}
